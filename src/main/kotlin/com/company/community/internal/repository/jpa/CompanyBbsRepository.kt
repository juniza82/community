package com.company.community.internal.repository.jpa

import com.company.community.internal.entity.jpa.CompanyBbsEntity
import com.company.community.internal.entity.jpa.UsersEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyBbsRepository : JpaRepository<CompanyBbsEntity, Int>, CompanyBbsCustomRepository {
//    fun findAll(codes: List<String>): List<UsersEntity>
//    fun findById(id: Int): UsersEntity
}

interface CompanyBbsCustomRepository {

}