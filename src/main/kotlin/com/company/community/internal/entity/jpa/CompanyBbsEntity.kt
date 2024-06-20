package com.company.community.intenal.entity.jpa

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

@Entity
@Comment("회사에서 사용하는 게시판들")
@Table(name = "Company_bbs")
open class CompanyBbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("ID")
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Comment("게시판구분")
    @Column(name = "company_type")
    open var companyType: String? = null

    @Comment("제목")
    @Column(name = "title")
    open var title: String? = null

    @Comment("내용")
    @Column(name = "content")
    open var content: String? = null

    @Comment("글확인수")
    @Column(name = "view_count")
    open var viewCount: Int = 0

    @Comment("정렬순서")
    @Column(name = "ordering")
    open var ordering: Int = 999

    @Comment("삭제일")
    @Column(name = "deleted_date")
    open var deletedDate: LocalDateTime = LocalDateTime.now()

    @Comment("삭제여부")
    @Column(name = "deleted_flag")
    open var deleteㅇFlag: String = "N"

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
