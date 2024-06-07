package com.company.community.internal.dto.request

import io.swagger.v3.oas.annotations.media.Schema

class CompanyBbsRequestDto(
    @Schema(description = "회사게시판 타입") var type: String = "",
    @Schema(description = "회사게시판 제목") var title: String = "",
    @Schema(description = "회사게시판 내용") var content: String = "",
    @Schema(description = "노출 유무") var isFront: Boolean = false,
)