package com.company.community.internal.service

import com.company.community.intenal.entity.jpa.UsersEntity
import com.company.community.internal.dto.UserDto
import com.company.community.internal.repository.jpa.UsersEntityRepository
import com.company.community.internal.repository.mapper.UsersTableMapper
import org.modelmapper.ModelMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull


@Service
class UserService(
    final val usersEntityRepository: UsersEntityRepository,
    final val usersMapper: UsersTableMapper,
    final val modelMapper: ModelMapper,
) {
    
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    fun selectAllUser(
//        searchText: String,
//        pageable: Pageable
    ): List<UsersEntity> {

//        var a = usersEntityRepository.findAll()
        var a = usersEntityRepository.findById(1).getOrNull()
        // mpdelMapper를 이용하여 Entity -> Dto 로 복사.
        var b = modelMapper.map(a, UserDto::class.java)


        // myBatis 를 이용한 쿼리
        var mapperCnt = usersMapper.selectUsersTotalCnt()
        print(mapperCnt)


        return usersEntityRepository.findAll()
    }

}