package com.company.community.internal.service

import com.company.community.intenal.entity.jpa.NoticeEntity
import com.company.community.intenal.entity.jpa.UsersEntity
import com.company.community.internal.dto.UserDto
import com.company.community.internal.repository.jpa.NoticeRepository
import com.company.community.internal.repository.jpa.UsersRepository
import com.company.community.internal.repository.mapper.UsersTableMapper
import org.modelmapper.ModelMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull


@Service
class NoticeService(
    final val modelMapper: ModelMapper,
    final val usersRepository: UsersRepository,
    final val noticeRepository: NoticeRepository,
//    final val usersMapper: UsersTableMapper,
) {
    
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    fun selectAllNotices(
//        searchText: String,
        pageable: Pageable
    ): List<NoticeEntity> {
        log.info("공지사항 전체 조회를 시작합니다. : hotelName - {}", "searchText")

//        var a = usersRepository.findAll()
//        var a = usersRepository.findById(1).getOrNull()
        // mpdelMapper를 이용하여 Entity -> Dto 로 복사.
//        var b = modelMapper.map(a, UserDto::class.java)

//        var notices = noticeRepository.findAll(PageRequest.of(pageable.pageNumber, pageable.pageSize))
        var notices = noticeRepository.findAll(pageable)
        println(notices)

        try {

        } catch (e: Exception) {
            log.error("Error Mesage :: {}", e.stackTrace)
        }

        return noticeRepository.findAll()
    }

}