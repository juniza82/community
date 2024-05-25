package com.company.community.internal.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.company.community.intenal.entity.jpa.UsersEntity
import com.company.community.internal.service.UserService
import io.swagger.v3.oas.annotations.Operation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.repository.JobRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class HelloController(
    private val objectMapper: ObjectMapper,
    private val jobRepository: JobRepository,
//    private val elasticsearchOperations: ElasticsearchOperations,
//    private val slackProvider: SlackProvider,
    private val userService: UserService,
) {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/listAll")
    @Deprecated(message = "이건 스웨거에서 사용안할때 사용")
    @Operation(summary = "API 요약", description = "API 설명")
    fun errorLogTest(): List<UsersEntity> {
        log.info("TEST LOG ::::::: ")

        return userService.selectAllUser()
    }


}

