package com.company.community.internal.dto.request

import io.swagger.v3.oas.annotations.media.Schema

class UserDto(
    @Schema(description = "회원ID", required = false) var userId: String? = null,
    @Schema(description = "회원이름", required = false) var userName: String? = null,
    @Schema(description = "비밀번호", required = false) var userPassword: String? = null,
    @Schema(description = "성별(M:Man, W:Woman)", required = false) var userGender: String? = null,
    @Schema(description = "유저생년월일 (ex. 1970.01.01)", required = false) var userBirthday: Int? = null,
    @Schema(description = "유저이메일", required = false) var userEmail: String? = null,
    @Schema(description = "유저전화", required = false) var userTel: String? = null,
    @Schema(description = "유저핸드폰번호", required = false) var userPhone: String? = null,
    @Schema(description = "유저핸드폰번호확인(Y,N)", required = false) var userPhoneCheck: String? = null,
    @Schema(description = "유저등급", required = false) var userGrade: String? = null,
    @Schema(description = "유저기기", required = false) var useragent: String? = null,
    @Schema(description = "유저기기버전", required = false) var userVersion: String? = null,
    @Schema(description = "유저로그인 가능 유무 토큰유효여부(Y,N)", required = false) var userAuthenticated: String? = null,
    @Schema(description = "유저상태", required = false) var userStatus: String? = null,
    @Schema(description = "회원탈퇴일", required = false) var deletedDate: String? = null,
    @Schema(description = "회원탈퇴여부", required = false) var deletedFlag: String? = null,
)

