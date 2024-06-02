package com.company.community.internal.repository.jpa

import com.company.community.intenal.entity.jpa.UsersEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository : JpaRepository<UsersEntity, Int>, CustomUsersRepository {
//    fun findAll(codes: List<String>): List<UsersEntity>
//    fun findById(id: Int): UsersEntity
}

interface CustomUsersRepository {
    fun findByUserName(filter: String): List<UsersEntity>
}