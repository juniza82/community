package com.company.community.intenal.entity.jpa

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
    @Column(name = "user_id", nullable = false)
    open var userId: String? = null

    @Comment("비밀번호")
    @Column(name = "user_password", nullable = false)
    open var userPassword: String? = null

    @Comment("보이는비밀번호")
    @Column(name = "user_view_password", nullable = false)
    open var userViewPassword: String? = null

    @Comment("유저로그인수단")
    @Column(name = "user_prodvider", nullable = false)
    open var userProdvider: String? = null

    @Comment("유저애플")
    @Column(name = "user_apple", nullable = false)
    open var userApple: String? = null

    @Comment("유저구글")
    @Column(name = "user_google", nullable = false)
    open var userGoogle: String? = null

    @Comment("유저네이버")
    @Column(name = "user_naver", nullable = false)
    open var userNaver: String? = null

    @Comment("유저라인")
    @Column(name = "user_line", nullable = false)
    open var userLine: String? = null

    @Comment("유저카카오")
    @Column(name = "user_kakao", nullable = false)
    open var userKakao: String? = null

    @Size(max = 100)
    @Comment("유저이름")
    @Column(name = "user_name", length = 100)
    open var userName: String? = null

    @Comment("유저성별")
    @Column(name = "user_gender", length = 300)
    open var userGender: String? = null

    @Comment("유저생년월일")
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
    @Comment("유저핸드폰번호확인")
    @Column(name = "user_phone_check", length = 30)
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

    @Comment("유저로그인 가능 유무 토큰유효여부")
    @Column(name = "user_authenticated")
    open var userAuthenticated: String? = null

    @Comment("유저상태")
    @Column(name = "user_status")
    open var userStatus: String? = null

    @Comment("회원탈퇴일")
    @Column(name = "deleted_date")
    open var deletedDate: LocalDateTime = LocalDateTime.now()

    @Comment("회원탈퇴여부")
    @Column(name = "deleted_flag")
    open var deletedFlag: Int = 0

    @NotNull
    @Comment("회원가입일")
    @Column(name = "created_date", nullable = false)
    open var createdDate: LocalDateTime = LocalDateTime.now()

    @Comment("회원생성ID")
    @Column(name = "created_id", nullable = false)
    open var createdId: String? = null

    @NotNull
    @Comment("회원수정일")
    @Column(name = "modified_date", nullable = false)
    open var modifiedDate: LocalDateTime = LocalDateTime.now()

    @Comment("회원수정ID")
    @Column(name = "modified_id", nullable = false)
    open var modifiedId: String? = null
}
