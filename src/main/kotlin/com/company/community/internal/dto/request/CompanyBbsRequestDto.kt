package com.company.community.internal.dto.request

import io.swagger.v3.oas.annotations.media.Schema

class CompanyBbsRequestDto(
    @Schema(description = "회사게시판 타입") var bbsType: String = "",
    @Schema(description = "회사게시판 제목") var title: String = "",
    @Schema(description = "회사게시판 내용") var content: String = "",
    @Schema(description = "회사게시판 순서") var ordering: String = "",
    @Schema(description = "게시글 노출 마지막 날짜") var deletedDate: String = "",
    @Schema(description = "게시글 삭제여부") var deletedFlag: String = ""
)