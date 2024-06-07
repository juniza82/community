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
class UsersController(
    private val objectMapper: ObjectMapper,
    private val userService: UserService,
) {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    // get post put delete
    // user

    // 유저 조회 정보
    @GetMapping("/users")
    @Deprecated(message = "이건 스웨거에서 사용안할때 사용")
    @Operation(summary = "API 요약", description = "API 설명")
    fun getUsers(): List<UsersEntity> {
        log.info("전체 요저 정보 조히 시작")

        return userService.selectAllUser()
    }




}

