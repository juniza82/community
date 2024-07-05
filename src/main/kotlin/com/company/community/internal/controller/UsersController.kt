package com.company.community.internal.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.company.community.internal.entity.jpa.UsersEntity
import com.company.community.internal.dto.request.UserDto
import com.company.community.internal.service.UserService
import io.swagger.v3.oas.annotations.Operation
import org.modelmapper.ModelMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.repository.JobRepository
import org.springframework.web.bind.annotation.*

@RequestMapping("users")
@RestController
class UsersController(
    private val objectMapper: ObjectMapper,
    private val modelMapper: ModelMapper,
    private val userService: UserService,
) {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    // put delete
    // user

    @PostMapping("/user")
    @Operation(summary = "회원 등록 API", description = "회원 한명을 등록")
    fun postUser(
        @RequestBody userDto: UserDto
    ) {
        log.info("회원 등록 API 호출")

        userService.insertUser(userDto)
    }

    // 유저 조회 정보
    @GetMapping("/user")
    @Deprecated(message = "이건 스웨거에서 사용안할때 사용")
    @Operation(summary = "API 요약", description = "API 설명")
    fun getUsers(): List<UsersEntity> {
        log.info("전체 요저 정보 조히 시작")

        return userService.selectAllUser()
    }




}

