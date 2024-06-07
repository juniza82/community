package com.company.community.internal.repository.jpa

import com.company.community.intenal.entity.jpa.NoticeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface NoticeRepository : JpaRepository<NoticeEntity, Int>, NoticeCustomRepository {
//    fun findAll(codes: List<String>): List<UsersEntity>
//    fun findById(id: Int): UsersEntity
}

interface NoticeCustomRepository {
//    fun findByUserName(filter: String): List<UsersEntity>
}