package com.company.community.test.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.company.community.common.provider.SlackProvider
import com.company.community.internal.dto.request.CompanyBbsRequestDto
import com.company.community.internal.service.CompanyBbsService
import com.company.community.test.service.TestService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.repository.JobRepository
import org.springframework.web.bind.annotation.*
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations

@RestController
@RequestMapping("/test")
class TestController(
    private val objectMapper: ObjectMapper,
    private val jobRepository: JobRepository,
//    private val elasticsearchOperations: ElasticsearchOperations,
    private val slackProvider: SlackProvider,

    private val testService: TestService,
) {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/error")
    fun errorLogTest() {
        log.error("TEST LOG")
//        slackProvider.expediaHotelReservationMessageSender()
//        slackProvider.expediaHotelReservationCancelMessageSender()
//        testService.testSer()
    }

    @PostMapping("/{bbsType}")
    fun insertCompanyBbsTest(
        @RequestBody companyBbsRequestDto: CompanyBbsRequestDto
    ) {
        testService.insertCompanyBbs(companyBbsRequestDto)
    }


}