package com.company.community.intenal.entity.jpa

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

@Entity
@Comment("공지사항")
@Table(name = "notice")
open class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("ID")
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Comment("제목")
    @Column(name = "title", length = 1000)
    open var title: String? = null

    @Comment("내용")
    @Column(name = "content")
    open var content: String? = null

    @Comment("정렬순서")
    @Column(name = "ordering")
    open var ordering: Int? = null

    @Comment("삭제 유무")
    @Column(name = "delete_flag")
    open var deleteFlag: Char? = null

    @NotNull
    @Comment("등록일")
    @Column(name = "created_date", nullable = false)
    open var createdDate: LocalDateTime = LocalDateTime.now()

    @Comment("등록자ID")
    @Column(name = "created_id", nullable = false)
    open var createdId: String? = null

    @NotNull
    @Comment("수정일")
    @Column(name = "modified_date", nullable = false)
    open var modifiedDate: LocalDateTime = LocalDateTime.now()

    @Comment("수정자ID")
    @Column(name = "modified_id", nullable = false)
    open var modifiedId: String? = null

}
