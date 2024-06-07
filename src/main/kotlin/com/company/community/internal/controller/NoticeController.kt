package com.company.community.internal.controller

import com.company.community.intenal.entity.jpa.NoticeEntity
import com.fasterxml.jackson.databind.ObjectMapper
import com.company.community.intenal.entity.jpa.UsersEntity
import com.company.community.internal.service.NoticeService
import com.company.community.internal.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.repository.JobRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class NoticeController(
    private val objectMapper: ObjectMapper,
    private val noticeService: NoticeService,
) {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    // get post put delete
    // notice

    // 유저 공지사항 정보
    @GetMapping("/notices")
    @Operation(summary = "[API] 전체 공지사항 조회", description = "전체 공지사항 조회시 사용")
    fun getUsers(
        @Schema(description = "페이지 사이즈", nullable = true) @RequestParam size: Int,
        @Schema(description = "페이지 번호", nullable = true) @RequestParam page: Int
    ): List<NoticeEntity> {
        log.info("전체 공지사항 정보 조히 시작")

        return noticeService.selectAllNotices(PageRequest.of(page, size))
    }




}

