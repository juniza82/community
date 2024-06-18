package com.company.community.internal.repository.jpa

import com.company.community.intenal.entity.jpa.UsersEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository : JpaRepository<UsersEntity, Int>, UsersCustomRepository {
//    fun findAll(codes: List<String>): List<UsersEntity>
//    fun findById(id: Int): UsersEntity
}

interface UsersCustomRepository {
    fun findByUserName(filter: String): List<UsersEntity>
}