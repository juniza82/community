package com.company.community.common.log

import com.company.community.common.model.ReqResLogging
import com.company.community.config.CustomException
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import org.yaml.snakeyaml.util.UriEncoder
import java.net.InetAddress
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// AOP 에처 logging 을 처리 할것인가?
//@Aspect
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
class RequestLoggingAspect(
    @Value("\${spring.profiles.active}")
    val profile: String,
    private val objectMapper: ObjectMapper
) {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)
    private val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    @Pointcut("execution(* com.company.community..*Controller.*(..))")
    fun logRequest() { }

    @Around("logRequest()")
    fun doLogging(joinPoint: ProceedingJoinPoint): Any? {

        try {
            val request = ((RequestContextHolder.currentRequestAttributes()) as ServletRequestAttributes).request
            val traceId = request.getAttribute("traceId") as String
            val className = joinPoint.signature.declaringTypeName // 1.
            val methodName = joinPoint.signature.name // 2.
            val params = getParams(request) // 3.
            val deviceType = request.getHeader("x-custom-device-type")
            val serverIp = InetAddress.getLocalHost().hostAddress

            val reqResLogging = ReqResLogging(
                traceId = traceId,
                className = className,
                httpMethod = request.method,
                uri = request.requestURI,
                method = methodName,
                params = params,
                logTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
                serverIp = serverIp,
                deviceType = deviceType,
                requestBody = objectMapper.readTree(request.inputStream.readBytes())
            )

            val start = System.currentTimeMillis() // 4.
            try {
                val result = joinPoint.proceed() // 5.
                val elapsedTime = System.currentTimeMillis() - start
                val elapsedTimeStr = "Method: $className.$methodName() execution time: ${elapsedTime}ms"

                // 6.
                val logging = when (result) {
                    is ResponseEntity<*> -> reqResLogging.copy(responseBody = result.body, elapsedTime = elapsedTimeStr)
                    else -> reqResLogging.copy(responseBody = "{}")
                }
                log.info(objectMapper.writeValueAsString(logging)) // 7.
                return result
            } catch (e: Exception) {
                log.info(
                    "{}",
                    objectMapper.writeValueAsString(
                        reqResLogging.copy(
                            responseBody = CustomException(
                                status = HttpStatus.INTERNAL_SERVER_ERROR,
                                code = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                traceId = traceId,
                                message = "서버에 일시적인 장애가 있습니다."
                            )
                        )
                    )
                )
                throw e // 8.
            }
/*

            val originHeaders = mutableMapOf<String, String>()
            request.headerNames.toList().map { headerStr ->
                originHeaders[headerStr] = UriEncoder.decode(request.getHeader(headerStr))
            }

            val url = request.requestURI

            if(url == "/healthcheck") return joinPoint.proceed()

//            if (profile == "stage" || profile == "prod") {
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
                            "function" to joinPoint.signature.name,
                            "headers" to headersMap,
                            "params" to paramsMap
                        )
                    )
                )
//            }
*/

        } catch (e: Exception) {
            log.error("로그 생성 도중 Exception이 발생 하였습니다. - {}", e.stackTrace)
            log.error("로그 생성 도중 Exception이 발생 하였습니다. - {}", e.message)
        }

        return joinPoint.proceed()
    }

    private fun objectToJsonStr(any: Map<String, Any>): String {
        return objectMapper.writeValueAsString(any)
    }

    private fun getParams(request: HttpServletRequest): Map<String, String> {
        val jsonObject = mutableMapOf<String, String>()
        val paramNames = request.parameterNames
        while (paramNames.hasMoreElements()) {
            val paramName = paramNames.nextElement()
            val replaceParam = paramName.replace("\\.", "-")
            jsonObject[replaceParam] = request.getParameter(paramName)
        }
        return jsonObject
    }
}