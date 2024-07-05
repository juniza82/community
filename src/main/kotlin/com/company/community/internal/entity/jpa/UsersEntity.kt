package com.company.community.internal.entity.jpa

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

@Entity
@Comment("회원")
@Table(name = "users")
open class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("ID")
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Comment("회원ID")
    @Column(name = "user_id")
    open var userId: String? = null

    @Comment("비밀번호")
    @Column(name = "user_password")
    open var userPassword: String? = null

    @Comment("보이는비밀번호")
    @Column(name = "user_view_password")
    open var userViewPassword: String? = null

    @Comment("유저로그인수단")
    @Column(name = "user_prodvider")
    open var userProdvider: String? = null

    @Comment("유저애플")
    @Column(name = "user_apple")
    open var userApple: String? = null

    @Comment("유저구글")
    @Column(name = "user_google")
    open var userGoogle: String? = null

    @Comment("유저네이버")
    @Column(name = "user_naver")
    open var userNaver: String? = null

    @Comment("유저라인")
    @Column(name = "user_line")
    open var userLine: String? = null

    @Comment("유저카카오")
    @Column(name = "user_kakao")
    open var userKakao: String? = null

    @Size(max = 100)
    @Comment("유저이름")
    @Column(name = "user_name", length = 100)
    open var userName: String? = null

    @Comment("유저성별 (M:Man, W:Woman)")
    @Column(name = "user_gender", length = 1)
    open var userGender: String? = null

    @Comment("유저생년월일 (ex. 1970.01.01)")
    @Column(name = "user_birthday")
    open var userBirthday: String? = null

    @Size(max = 100)
    @Comment("유저이메일")
    @Column(name = "user_email", length = 100)
    open var userEmail: String? = null

    @Size(max = 30)
    @Comment("유저전화")
    @Column(name = "user_tel", length = 30)
    open var userTel: String? = null

    @Size(max = 30)
    @Comment("유저핸드폰번호")
    @Column(name = "user_phone", length = 30)
    open var userPhone: String? = null

    @Size(max = 30)
    @Comment("유저핸드폰번호확인 ('Y', 'N')")
    @Column(name = "user_phone_check", length = 1)
    open var userPhoneCheck: String? = null

    @Comment("유저등급")
    @Column(name = "user_grade")
    open var userGrade: String? = null

    @Comment("유저기기")
    @Column(name = "user_agent")
    open var useragent: String? = null

    @Comment("유저기기버전")
    @Column(name = "user_version")
    open var userVersion: String? = null

    @Comment("유저로그인 가능 유무 토큰유효여부 ('Y', 'N')")
    @Column(name = "user_authenticated", length = 1)
    open var userAuthenticated: String = "N"

    @Comment("유저상태")
    @Column(name = "user_status")
    open var userStatus: String? = null

    @Comment("회원탈퇴일")
    @Column(name = "deleted_date")
    open var deletedDate: LocalDateTime? = null

    @Comment("회원탈퇴여부")
    @Column(name = "deleted_flag", length = 1)
    open var deletedFlag: String = "N"

    @Comment("회원가입일")
    @Column(name = "created_date", nullable = false, updatable = false)
    open var createdDate: LocalDateTime = LocalDateTime.now()

    @Comment("회원생성ID")
    @Column(name = "created_id")
    open var createdId: String? = null

    @Comment("회원수정일")
    @Column(name = "modified_date", nullable = false, updatable = true)
    open var modifiedDate: LocalDateTime = LocalDateTime.now()

    @Comment("회원수정ID")
    @Column(name = "modified_id")
    open var modifiedId: String? = null
}
