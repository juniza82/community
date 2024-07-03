package com.company.community.config

import org.springframework.http.HttpStatus

class CustomException(override val message: String, status: HttpStatus, code: Int, traceId: String): Exception() {

}