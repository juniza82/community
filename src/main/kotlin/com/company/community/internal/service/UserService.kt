package com.company.community.internal.service

import com.company.community.intenal.entity.jpa.UsersEntity
import com.company.community.internal.dto.UserDto
import com.company.community.internal.repository.jpa.UsersEntityRepository
import org.modelmapper.ModelMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull


@Service
class UserService(
    final val usersEntityRepository: UsersEntityRepository,
//    final val usersMapper: UsersMapper,
    final val modelMapper: ModelMapper,
) {
    
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    fun selectAllUser(
//        searchText: String,
//        pageable: Pageable
    ): List<UsersEntity> {

//        var a = usersEntityRepository.findAll()
        var a = usersEntityRepository.findById(1).getOrNull()
        println(a)

        var b = modelMapper.map(a, UserDto::class.java)
        println(b)



        return usersEntityRepository.findAll()
    }

}