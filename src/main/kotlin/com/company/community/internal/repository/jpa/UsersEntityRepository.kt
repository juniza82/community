package com.company.community.internal.repository.jpa

import com.company.community.intenal.entity.jpa.UsersEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UsersEntityRepository : JpaRepository<UsersEntity, Int> {
//    fun findAll(codes: List<String>): List<UsersEntity>
//    fun findById(id: Int): UsersEntity
}