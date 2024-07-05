package com.company.community.config.security

import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.stereotype.Component
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jakarta.annotation.PostConstruct
import jakarta.servlet.FilterChain
import org.slf4j.LoggerFactory
import org.slf4j.Logger
import com.fasterxml.jackson.databind.ObjectMapper
import com.company.community.common.constant.AgentKeys.Companion.COMPANY_ID_KEY
import com.company.community.common.constant.AgentKeys.Companion.USER_ID_KEY
import com.company.community.common.constant.AgentKeys.Companion.JWT_KEY
import com.company.community.config.utils.ResponseEntityUtils.Companion.getFailedResponseDto
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder

@Component
class RequestFilter(
    private val objectMapper: ObjectMapper,
): OncePerRequestFilter() {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)
    private final lateinit var failureJson: String

    private val swaggerUris = arrayOf("/swagger-ui", "/v3/api-docs")
    private val lifeCycleCheckUri = "/healthcheck"
    private val cacheUri = "/cache"

    @PostConstruct
    fun init() {
        failureJson = objectMapper.writeValueAsString(getFailedResponseDto().body)
    }

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        val uriStr: String = request.requestURI?.toString() ?: ""

        if (isSwaggerUri(uriStr)
            || uriStr == lifeCycleCheckUri
            || uriStr.startsWith(cacheUri)
        ) {
            log.info("$uriStr : 페이지 접근 확인")
            filterChain.doFilter(request, response)
            return
        }

        val companyId = request.getHeader(COMPANY_ID_KEY)
        val userId = request.getHeader(USER_ID_KEY)
        val jwtToken = request.getHeader(JWT_KEY)

//        if (
//            checkAgentInfoIsNull(userId, travelAgentId, companyName,
//            address, businessNum, callNum, fax, email, logo, phone)
//        || jwtToken.isEmpty()) {
//
//            val headers = mutableMapOf<String, String>()
//            request.headerNames.toList().map {
//                headers[it] = request.getHeader(it)
//            }
//
//            log.error("유저와 공급사 정보를 확인 할 수 없습니다. : url - {}, headers - {}", uriStr, headers)
//            setFailureResponse(response)
////            return
//        }

//        SecurityContextHolder.getContext().authentication =
//            UsernamePasswordAuthenticationToken(
//                TravelAgent(
//                    userId = userId,
//                    id = travelAgentId,
//                    name = UriEncoder.decode(companyName),
//                    address = UriEncoder.decode(address),
//                    businessNumber = businessNum,
//                    telNumber = callNum,
//                    faxNumber = fax,
//                    email = UriEncoder.decode(email),
//                    logoUrl = UriEncoder.decode(logo),
//                    mobileNumber = phone,
//                    jwtToken = jwtToken,
//                    eodingDiscountPercentage = getTravelAgentHotelEodingCommissionPercentage(travelAgentId)
//                ),
//                null,
//                emptyList()
//            )

        filterChain.doFilter(request, response)
    }

    private fun setFailureResponse(response: HttpServletResponse) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.writer.write(failureJson)
        response.status = HttpStatus.FORBIDDEN.value()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
    }

    private fun isSwaggerUri(uriStr:String?): Boolean {
        if (uriStr == null) return false
        for (uri in swaggerUris)
            if (uriStr.startsWith(uri)) return true
        return false
    }

    private fun checkAgentInfoIsNull(vararg headers: String?): Boolean {
        return headers.map { it == null }.any { it }
    }

}