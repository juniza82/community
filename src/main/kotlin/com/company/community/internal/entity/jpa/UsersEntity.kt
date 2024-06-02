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
    @Column(name = "password", length = 300)
    open var password: String? = null

    @Comment("보이는 비밀번호")
    @Column(name = "view_password", length = 300)
    open var viewPassword: String? = null

    @Comment("소셜로그인 공급자 ex)구글, 네이버, 카카오, 애플")
    @Column(name = "user_prodvider")
    open var userProdvider: String? = null

    @Comment("소셜로그인 구글 ID")
    @Column(name = "user_google")
    open var userGoogle: String? = null

    @Comment("소셜로그인 네이버 ID")
    @Column(name = "user_naver")
    open var userNaver: String? = null

    @Comment("소셜로그인 카카오 ID")
    @Column(name = "user_kakao")
    open var userKakao: String? = null

    @Comment("소셜로그인 애플 ID")
    @Column(name = "user_apple")
    open var userApple: String? = null

    @Comment("사용자 이름")
    @Column(name = "user_name")
    open var userName: String? = null

    @Comment("사용자 성별")
    @Column(name = "user_gender")
    open var userGender: Int? = 0

    @Comment("사용자 생년월일")
    @Column(name = "user_birthday")
    open var userBirthday: String? = null

    @Size(max = 100)
    @Comment("사용자 이메일")
    @Column(name = "user_email", length = 100)
    open var userEmail: String? = null

    @Size(max = 30)
    @Comment("사용자 전화")
    @Column(name = "user_tel", length = 30)
    open var userTel: String? = null

    @Size(max = 30)
    @Comment("사용자 핸드폰")
    @Column(name = "user_phone", length = 30)
    open var userPhone: String? = null

    @Comment("핸드폰 인증 유무")
    @Column(name = "user_phone_check")
    open var userPhoneCheck: Int? = 0

    @Comment("사용자 등급")
    @Column(name = "user_grade")
    open var userGrade: String? = null

    @Comment("핸드폰 기기")
    @Column(name = "user_client_id")
    open var userClientType: String? = null

    @Comment("앱 버전")
    @Column(name = "user_client_version")
    open var userClientVersion: String? = null

    @Comment("로그인 가능 유무 토큰유효여부")
    @Column(name = "user_authenticated")
    open var userAuthenticated: Int? = 0

    @Comment("회원 상태 ex) 활성, 휴먼, 탈퇴? 이게 왜 있어야 하지?")
    @Column(name = "user_status")
    open var userStatus: String? = null

    @Comment("사용자 탈퇴 날짜")
    @Column(name = "user_delete_date", nullable = false)
    open var user_delete_date: LocalDateTime = LocalDateTime.now()

    @Comment("사용자 탈퇴여부")
    @Column(name = "deleted_flg")
    open var deletedFlg: String? = null

    @NotNull
    @Comment("등록일")
    @Column(name = "created_date", nullable = false)
    open var createdDate: LocalDateTime = LocalDateTime.now()

    @Comment("등록자ID")
    @Column(name = "created_id", nullable = false)
    open var createdId: String? = null

    @NotNull
    @Comment("수정일")
    @Column(name = "modify_date", nullable = false)
    open var modifyDate: LocalDateTime = LocalDateTime.now()

    @Comment("수정자ID")
    @Column(name = "modified_id", nullable = false)
    open var modifiedId: String? = null

}
