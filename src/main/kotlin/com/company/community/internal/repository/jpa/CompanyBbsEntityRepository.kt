package com.company.community.internal.repository.jpa

import com.company.community.intenal.entity.jpa.CompanyBbsEntity
import com.company.community.intenal.entity.jpa.UsersEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyBbsEntityRepository : JpaRepository<CompanyBbsEntity, Int>, CompanyBbsCustomRepository {
//    fun findAll(codes: List<String>): List<UsersEntity>
//    fun findById(id: Int): UsersEntity
}

interface CompanyBbsCustomRepository {

}