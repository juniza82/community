package com.company.community.config.security

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class ReqResLoggingFilter(
    private val objectMapper: ObjectMapper,
): OncePerRequestFilter() {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    companion object {
        const val REQUEST_ID = "request_id"
    }

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        val uriStr: String = request.requestURI?.toString() ?: ""

        val cachingRequestWrapper = ContentCachingRequestWrapper(request)
        val cachingResponseWrapper = ContentCachingResponseWrapper(response)

        val startTime = System.currentTimeMillis()
        filterChain.doFilter(cachingRequestWrapper, cachingResponseWrapper)
        val end = System.currentTimeMillis()

        try {
            log.info(
                HttpLogMessage.createInstance(
                    requestWrapper = cachingRequestWrapper,
                    responseWrapper = cachingResponseWrapper,
                    elapsedTime = (end - startTime) / 1000.0
                ).toPrettierLog()
//                ""
            )

            cachingResponseWrapper.copyBodyToResponse()
        } catch (e: Exception) {
            val aa = "[${this::class.simpleName}] Logging 실패"
//            log.error(e) { "[${this::class.simpleName}] Logging 실패" }
            log.error("{}", aa)
        }

    }

}

// HttpLogMessage
data class HttpLogMessage(
    val httpMethod: String,
    val requestUri: String,
    val httpStatus: HttpStatus,
    val clientIp: String,
    val elapsedTime: Double,
    val headers: String?,
    val requestParam: String?,
    val requestBody: String?,
    val responseBody: String?,
) {
    companion object {
        fun createInstance(
            requestWrapper: ContentCachingRequestWrapper,
            responseWrapper: ContentCachingResponseWrapper,
            elapsedTime: Double
        ): HttpLogMessage {
            return HttpLogMessage(
                httpMethod = requestWrapper.method,
                requestUri = requestWrapper.requestURI,
                httpStatus = HttpStatus.valueOf(responseWrapper.status),
//                clientIp = requestWrapper.getClientIp(),
                clientIp = "",
                elapsedTime = elapsedTime,
//                headers = requestWrapper.getRequestHeaders(),
                headers = "",
//                requestParam = requestWrapper.getRequestParams(),
                requestParam = "",
//                requestBody = requestWrapper.getRequestBody(),
                requestBody = "",
//                responseBody = responseWrapper.getResponseBody(),
                responseBody = "",
            )
        }
    }

    // 이부분은 각자 취향대로 포멧 정하는 것으로,,,
    fun toPrettierLog(): String {
        return """
        |
        |[REQUEST] ${this.httpMethod} ${this.requestUri} ${this.httpStatus} (${this.elapsedTime})
        |>> CLIENT_IP: ${this.clientIp}
        |>> HEADERS: ${this.headers}
        |>> REQUEST_PARAM: ${this.requestParam}
        |>> REQUEST_BODY: ${this.requestBody}
        |>> RESPONSE_BODY: ${this.responseBody}
        """.trimMargin()
    }
}