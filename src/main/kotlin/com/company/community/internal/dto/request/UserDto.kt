package com.company.community.internal.dto.request

import io.swagger.v3.oas.annotations.media.Schema

class UserDto(
    @Schema(description = "회원ID") var userId: String? = null,
    @Schema(description = "회원이름") var userName: String? = null,
    @Schema(description = "비밀번호") var userPassword: String? = null,
    @Schema(description = "성별(M:Man, W:Woman)") var userGender: String? = null,
    @Schema(description = "유저생년월일 (ex. 1970.01.01)") var userBirthday: String? = null,
    @Schema(description = "유저이메일") var userEmail: String? = null,
    @Schema(description = "유저전화") var userTel: String? = null,
    @Schema(description = "유저핸드폰번호") var userPhone: String? = null,
    @Schema(description = "유저핸드폰번호확인(Y,N)") var userPhoneCheck: String? = null,
    @Schema(description = "유저등급") var userGrade: String? = null,
    @Schema(description = "유저기기") var useragent: String? = null,
    @Schema(description = "유저기기버전") var userVersion: String? = null,
    @Schema(description = "유저로그인 가능 유무 토큰유효여부(Y,N)") var userAuthenticated: String? = null,
    @Schema(description = "유저상태") var userStatus: String? = null,
    @Schema(description = "회원탈퇴일") var deletedDate: String? = null,
    @Schema(description = "회원탈퇴여부") var deletedFlag: String? = null,
)

