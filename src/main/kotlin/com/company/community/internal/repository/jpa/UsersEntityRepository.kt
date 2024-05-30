package com.company.community.internal.repository.jpa

import com.company.community.intenal.entity.jpa.UsersEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UsersEntityRepository : JpaRepository<UsersEntity, Int>, CustomAdminRepository {
//    fun findAll(codes: List<String>): List<UsersEntity>
//    fun findById(id: Int): UsersEntity
}

interface CustomAdminRepository {
    fun findByUserName(filter: String): List<UsersEntity>
}