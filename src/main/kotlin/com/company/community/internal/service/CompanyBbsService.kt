package com.company.community.internal.service

import com.company.community.common.constant.DateConst
import com.company.community.common.rm.BooleanRm
import com.company.community.intenal.entity.jpa.CompanyBbsEntity
import com.company.community.intenal.entity.jpa.UsersEntity
import com.company.community.internal.dto.UserDto
import com.company.community.internal.dto.request.CompanyBbsRequestDto
//import com.company.community.internal.repository.jpa.CompanyBbsEntityRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service


@Service
class CompanyBbsService(
//    final val usersEntityRepository: UsersEntityRepository,
//    final val companyBbsEntityRepository: CompanyBbsEntityRepository,
//    final val modelMapper: ModelMapper,
) {
    
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    fun insertCompanyBbs(
        companyBbsRequestDto: CompanyBbsRequestDto
    ): BooleanRm {
        log.info("회사게시판 타입별로 등록 :: {}", companyBbsRequestDto.type)
        log.info("DTO ::: {}", companyBbsRequestDto)

        var result = try {
//            companyBbsEntityRepository.save(
//                modelMapper.map(companyBbsRequestDto, CompanyBbsEntity::class.java)
//            )
            BooleanRm().apply {
                data = true
                this.code = ""
                this.message = ""
                this.status = HttpStatus.BAD_REQUEST
            }
        } catch (e: Exception) {
            log.error("회사게시판 타입 - {}, DTO - {}", companyBbsRequestDto.type, companyBbsRequestDto)
            log.error("회사게시판 타입별로 등록에 실패했습니다. - {}", e.stackTrace)
            BooleanRm(
                data = false
            ).apply {
                this.code = ""
                this.message = ""
                this.status = HttpStatus.BAD_REQUEST
            }
        }



        return result

    }

    fun selectAllUser(
        type: String?
//        pageable: Pageable
    ): List<UsersEntity> {

//        var a = usersEntityRepository.findAll()
//        var a = usersEntityRepository.findById(1).getOrNull()
//        // mpdelMapper를 이용하여 Entity -> Dto 로 복사.
//        var b = modelMapper.map(a, UserDto::class.java)
//
//        var aa = usersEntityRepository.findByUserName("김종현")
//        println(aa)
//
//
//        return usersEntityRepository.findAll()

        return emptyList()
    }

}