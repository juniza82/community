package com.company.community

import com.company.community.internal.dto.request.CompanyBbsRequestDto
import com.company.community.internal.repository.jpa.CompanyBbsEntityRepository
import com.company.community.internal.service.CompanyBbsService
import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.modelmapper.ModelMapper
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ClassPathResource
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestPropertySource
import java.io.BufferedReader
import javax.annotation.meta.When

//@SpringBootTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(properties = ["spring.profiles.active=dev-local"]) // can override any propertysource
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL) // autowire without @autowired
class CommunityApplicationTests{

//	private val modelMapper: ModelMapper = mockk()
//	private val companyBbsEntityRepository: CompanyBbsEntityRepository = mockk()
//	private val companyBbsService: CompanyBbsService = CompanyBbsService(companyBbsEntityRepository, modelMapper)

	@Test
	fun contextLoads() {
		println("a")
	}

	@Test
	fun companyBbsServiceTest() {

//		// given("1과 2가 있고")
//		Given("1과 2가 있고") {
//			val one = 1
//			val two = 2
//
//			// `when`("1과 2를 더하면")
//			When("1과 2를 더하면") {
//				val actual = one + two
//
//				// then("3이다")
//				Then("3이다.") {
//					actual shouldBe 3
//				}
//			}
//		}

		var testNum = 9
		var titleNum = "" + testNum + testNum + testNum
		var contentNum = "" + testNum + testNum + testNum + testNum + testNum
//		CompanyBbsRequestDto().apply {
//			type = "notice"
//			title = "공지사항 - 제목" + titleNum
//			content = "공지사항 - 내용" + contentNum
//			isFront = true
//		}


//		companyBbsService.insertCompanyBbs()

//		// given
//		val username = "test"
//		every { aRepository.findByName(username) } returns expectedA
//
//		// when
//		val resultA = aService.findByName(username)
//
//
//		// then
//		verify(exactly==1) { aRepository.findByName(username) }
//		assertThat(username).isEqualTo(resultA.username)




//		val fileStream = ClassPathResource("iso_en-ko-2code-num_map.json").inputStream
//		val objectMapper = ObjectMapper()
//
//		val list = objectMapper.readValue(BufferedReader(fileStream.reader()).readText(), List::class.java)
//		val resultMap = mutableMapOf<String, Any>()
//		for (el in list) {
//			val map = objectMapper.readValue(el.toString(), Map::class.java)
//			resultMap[map.keys.first().toString()] = map[map.keys.first()] ?: ""
//		}
//
//		println(resultMap)

	}
}
