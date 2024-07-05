package com.company.community.internal.service

import com.company.community.internal.entity.jpa.UsersEntity
import com.company.community.internal.dto.request.UserDto
import com.company.community.internal.entity.jpa.CompanyBbsEntity
import com.company.community.internal.repository.jpa.UsersRepository
import com.company.community.internal.repository.mapper.UsersTableMapper
import org.modelmapper.ModelMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull


@Service
class UserService(
    final val modelMapper: ModelMapper,
    final val usersRepository: UsersRepository,
    final val usersMapper: UsersTableMapper,
) {
    
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    fun insertUser(
        userDto: UserDto
    ) {
        log.info("회원 등록 API 요청")

        val a = modelMapper.map(userDto, UsersEntity::class.java)

        usersRepository.save(
            modelMapper.map(userDto, UsersEntity::class.java).apply {
                createdId = "1"
                modifiedId = "1"
            }
        )
    }

    fun selectAllUser(
//        searchText: String,
//        pageable: Pageable
    ): List<UsersEntity> {

//        var a = usersRepository.findAll()
        var a = usersRepository.findById(1).getOrNull()
        // mpdelMapper를 이용하여 Entity -> Dto 로 복사.
        var b = modelMapper.map(a, UserDto::class.java)

        var aa = usersRepository.findByUserName("김종현")
        println(aa)

        // myBatis 를 이용한 쿼리
        var mapperCnt = usersMapper.selectUsersTotalCnt()
        print(mapperCnt)


        return usersRepository.findAll()
    }

}