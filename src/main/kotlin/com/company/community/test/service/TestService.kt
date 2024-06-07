package com.company.community.test.service

import com.company.community.intenal.entity.jpa.CompanyBbsEntity
import com.company.community.intenal.entity.jpa.UsersEntity
import com.company.community.internal.dto.request.CompanyBbsRequestDto
import com.company.community.internal.repository.jpa.CompanyBbsEntityRepository
import com.company.community.internal.repository.jpa.UsersEntityRepository
import org.modelmapper.ModelMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class TestService(
//    final val usersEntityRepository: UsersEntityRepository,
//    final val usersMapper: UsersMapper,
    val companyBbsEntityRepository: CompanyBbsEntityRepository,
    val modelMapper: ModelMapper,
) {
    
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

//    fun testtestSer(
////        searchText: String,
////        pageable: Pageable
//    ): List<UsersEntity> {
//        return usersEntityRepository.findAll()
//    }

    @Transactional
    fun insertCompanyBbs(
        companyBbsRequestDto: CompanyBbsRequestDto
    ) {

        for(i: Int in 1 ..100) {

            var testNum = i
            var titleNum = "" + testNum + testNum + testNum
            var contentNum = "" + testNum + testNum + testNum + testNum + testNum

        companyBbsEntityRepository.save(
            CompanyBbsEntity().apply {
                type = "notice"
                title = "NOTICE - 제목" + titleNum
                content = "NOTICE - 내용" + contentNum
                frontFlag = 1
                createdId = "admin"
                modifiedId = "admin"
            }
        )
        }
    }

}