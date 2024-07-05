package com.company.community.config.security

import com.company.community.config.CustomException
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.ReadListener
import jakarta.servlet.ServletInputStream
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletRequestWrapper
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.util.StreamUtils
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper
import org.yaml.snakeyaml.util.UriEncoder
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

// filter에서 logging 을 처리할 것인가?
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class ReqResLoggingFilter(
    @Value("\${spring.profiles.active}")
    val profile: String,

    private val objectMapper: ObjectMapper,
): OncePerRequestFilter() {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)
    private val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    private val swaggerUris = arrayOf("/swagger-ui", "/v3/api-docs")
    private val lifeCycleCheckUri = "/healthcheck"
    private val cacheUri = "/cache"

    companion object {
        const val REQUEST_ID = "request_id"
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

        /*
        // 1번 방법
        val request = ((RequestContextHolder.currentRequestAttributes()) as ServletRequestAttributes).request
        val originHeaders = mutableMapOf<String, String>()
        request.headerNames.toList().map { headerStr ->
            originHeaders[headerStr] = UriEncoder.decode(request.getHeader(headerStr))
        }

        val url = request.requestURI
        val headersMap = mutableMapOf<String, Any>()

        headersMap["origin"] = originHeaders

        val paramsMap = mutableMapOf<String, Any>()
        request.parameterNames.toList().forEach { key ->
            paramsMap[key] = UriEncoder.decode(request.getParameter(key))
        }

        println(
            objectToJsonStr(
                mutableMapOf (
                    "timestamp" to LocalDateTime.now().format(dateTimeFormatter),
                    "level" to "info",
                    "env" to if(profile == "stage") "stg" else profile,
                    "service" to "hotel-ota",
                    "url" to url,
                    "method" to request.method,
                    "headers" to headersMap,
                    "params" to paramsMap
                )
            )
        )*/


        /*
        // 2번째 방법 하지만 여기선 아무것도 찍지 않는다.
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
        }*/


        val traceId = UUID.randomUUID().toString()
        try {
            val requestWrapper = CachedBodyHttpServletRequest(request)
            requestWrapper.setAttribute("traceId", traceId)
            filterChain.doFilter(requestWrapper, response)
        } catch (e: Exception) {
            log.error(e.message)
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            val customException = CustomException(
                status = HttpStatus.INTERNAL_SERVER_ERROR,
                code = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                traceId = traceId,
                message = "Internal Server Error"
            )
            try {
                response.writer.use {
                    it.print(objectMapper.writeValueAsString(customException))
                    it.flush()
                }
            } catch (e: IOException) {
                log.warn("IOException Occur")
                throw RuntimeException()
            }
        }
    }


    private fun objectToJsonStr(any: Map<String, Any>): String {
        return objectMapper.writeValueAsString(any)
    }

    private fun isSwaggerUri(uriStr:String?): Boolean {
        if (uriStr == null) return false
        for (uri in swaggerUris)
            if (uriStr.startsWith(uri)) return true
        return false
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









class CachedBodyHttpServletRequest(request: HttpServletRequest) : HttpServletRequestWrapper(request) {

    private val cachedBody: ByteArray

    init {
        val requestInputStream = request.inputStream
        this.cachedBody = StreamUtils.copyToByteArray(requestInputStream)
    }

    override fun getInputStream(): ServletInputStream {
        return CachedBodyServletInputStream(this.cachedBody)
    }
}

class CachedBodyServletInputStream(cachedBody: ByteArray) : ServletInputStream() {

    private val cachedBodyInputStream: InputStream

    init {
        this.cachedBodyInputStream = ByteArrayInputStream(cachedBody)
    }

    override fun read(): Int = cachedBodyInputStream.read()

    override fun isFinished(): Boolean = cachedBodyInputStream.available() == 0

    override fun isReady(): Boolean = true

    override fun setReadListener(listener: ReadListener?) {
        TODO("Not yet implemented")
    }
}

