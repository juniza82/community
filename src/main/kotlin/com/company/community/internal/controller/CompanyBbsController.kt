package com.company.community.internal.controller

import com.company.community.common.rm.BooleanRm
import com.company.community.config.utils.ResponseEntityUtils.Companion.getResponseEntityWithBody
import com.fasterxml.jackson.databind.ObjectMapper
import com.company.community.intenal.entity.jpa.UsersEntity
import com.company.community.internal.dto.request.CompanyBbsRequestDto
import com.company.community.internal.service.CompanyBbsService
import com.company.community.internal.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.repository.JobRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/company/bbs")
@Tag(name = "회사게시판(공지사항, FAQ) 관리 Api", description = "회사게시판(공지사항, FAQ) 관리 api입니다.")
class CompanyBbsController(
    private val objectMapper: ObjectMapper,
    private val jobRepository: JobRepository,
    private val companyBbsService: CompanyBbsService,
) {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    // 회사게시판 관리 get, post, put, delete

    @PostMapping("/{bbsType}")
    @Operation(summary = "회사게시판(공지사항, FAQ) 관리 전체 등록", description = "회사게시판(공지사항, FAQ) 관리 전체 등록")
    fun insertCompanyBbs(
        @RequestBody companyBbsRequestDto: CompanyBbsRequestDto
    ): ResponseEntity<BooleanRm> {
        return getResponseEntityWithBody(
            companyBbsService.insertCompanyBbs(companyBbsRequestDto)
        )
    }

    /**
     *
     */
    @GetMapping("/{bbsType}")
    @Operation(summary = "회사게시판(공지사항, FAQ) 관리 전체 조회", description = "회사게시판(공지사항, FAQ) 관리 전체 조회")
    fun selectCompanyBbsType(
        @Schema(description = "회사게시판구분", nullable = true) @RequestParam type: String?,
//        @Schema(description = "예약 상태", nullable = true) @RequestParam status: List<Int>?,
        ): Boolean {
        log.info("회사게시판 타입별로 전체 조회 :: {}", type)





        return false
    }


    @GetMapping("/listAll")
    @Deprecated(message = "이건 스웨거에서 사용안할때 사용")
    @Operation(summary = "API 요약", description = "API 설명")
    fun errorLogTest(): List<UsersEntity> {
        log.info("TEST LOG ::::::: ")

//        return userService.selectAllUser()
        return listOf()
    }


}

