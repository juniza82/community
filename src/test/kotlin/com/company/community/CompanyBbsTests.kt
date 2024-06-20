package com.company.community

import org.apache.catalina.security.SecurityConfig
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.TestPropertySource

@AutoConfigureMockMvc
@Import(SecurityConfig::class)
@TestPropertySource(properties = ["spring.profiles.active=dev-local"])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CompanyBbsTests{
//	@Autowired private var mockMvc: MockMvc
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

/*
	//    @Disabled
	@BeforeEach
	fun init(){
		var userSingUpRequestDto0 = UserSingUpRequestDto().apply {
			userId = "juniza82@gmail.com"
			password ="juniza82"
			viewPassword ="juniza82"
			name = "김종현"
			idType = "REG_NO"
			idValue = "8210241234567"
		}
		var userSingUpRequestDto1 = UserSingUpRequestDto().apply {
			userId       = "sample@gmail.com"
			password     = "sample"
			viewPassword = "sample"
			name         = "김샘플"
			idType       = "BUSINESS_NO"
			idValue      = "6368100400"
		}
		var userSingUpRequestDto2 = UserSingUpRequestDto().apply {
			userId       = "moin@gmail.com"
			password     = "moin"
			viewPassword = "moin"
			name         = "김모인"
			idType       = "REG_NO"
			idValue      = "2001053412593"
		}
		var userSingUpRequestDto3 = UserSingUpRequestDto().apply {
			userId       = "test@gmail.com"
			password     = "test"
			viewPassword = "test"
			name         = "김과제"
			idType       = "BUSINESS_NO"
			idValue      = "6362130401"
		}
		val userList = mutableListOf(userSingUpRequestDto0, userSingUpRequestDto1, userSingUpRequestDto2, userSingUpRequestDto3)
		userList.map {
			userService.insertUser(it)
		}
	}

	@Test
	internal fun 암호화테스트() {
		val encrypted = aesEncryptProvider.useAESToEncrypt("juniza82")
		assertEquals(encrypted, "FQadPGMNKpcf9B0pkbsKAw==")
	}

	@Test
	internal fun 복호화테스트() {
		val encrypted = aesEncryptProvider.useAESToEncrypt("juniza82")?: ""
		assertEquals("juniza82", aesEncryptProvider.useAESToDecrypt(encrypted))
	}

	@Test
	@DisplayName("회원 가입 API")
	fun 회원가입API() {

		// given
		val userData = UserSingUpRequestDto().apply {
			userId       = "juniza82@gmail.com" // 이메일 형식을 사용해주세요
			password     = "juniza82"           // 패스워드
			viewPassword = "juniza82"           // 패스워드
			name         =  "김종현"              // 이름
			idType       =  "REG_NO"            // Documentation 참조
			idValue      =  "8210241234567"     // Documentation 참조
		}

		// when
		val result = userService.insertUser(userData)

		// then
		assertEquals(result.resultMessage, "200")
	}


	@Test
	fun jwt생성() {
		val token = jwtTokenProvider.generateJWTToken("juniza82@gmail.com", 1000)
		assertEquals(token.isNotEmpty(), true)
	}

	@Test
	fun jwtSubject조회() {
		val token = jwtTokenProvider.generateJWTToken("juniza82@gmail.com", 60000)
		val tokenSubject = jwtTokenProvider.getSubjectFromToken(token)
		assertEquals(tokenSubject, "juniza82@gmail.com")
	}

	@Test
	fun jwt만료조회테스트() {
		val token = jwtTokenProvider.generateJWTToken("juniza82@gmail.com", 1_000)
		Thread.sleep(1_000)
		assertEquals(jwtTokenProvider.isValidToken(token), false)
	}


	@Test
	@DisplayName("회원 로그인 API")
	fun 회원로그인API() {
		// given
		// @BeforeEach 에 회원가입을 한명 시킨다.
		val userData = UserLoginRequestDto().apply {
			userId       = "juniza82@gmail.com" // 이메일 형식을 사용해주세요
			password     = "juniza82"           // 패스워드
		}

		// when
		val resultSignUpDto = userService.postLogin(userData)

		// then
		assertEquals(resultSignUpDto.resultMessage, "200")
	}

	@Test
	fun 계산소수점자릿수테스트() {

		*//*[
            {
                "code": "FRX.KRWJPY",
                "currencyCode": "JPY",
                "basePrice": 907.98,
                "currencyUnit": 100
            },
            {
                "code": "FRX.KRWUSD",
                "currencyCode": "USD",
                "basePrice": 1302.00,
                "currencyUnit": 1
            }
        ]*//*

		var quotationDto = QuotationDto(
			code = "FRX.KRWUSD",
			currencyCode = "USD",
			basePrice = 1377.10,
			currencyUnit = 1
		)

		val amount = 100_000
		var commissionRate = 0.1
		var fixedFee = 3000
		var commission = 0.0


		commission = (amount * commissionRate / 100) + fixedFee
		val exchangeRate = (quotationDto.basePrice / quotationDto.currencyUnit) // 환율

		val resultAmount = (amount - commission) / exchangeRate
		println(resultAmount)
		println(round(resultAmount * 10.0.pow(0)) / 10.0.pow(0))
		println(round(resultAmount * 10.0.pow(1)) / 10.0.pow(1))
		println(round(resultAmount * 10.0.pow(2)) / 10.0.pow(2))
		println(round(resultAmount * 10.0.pow(3)) / 10.0.pow(3))

	}


	@Test
	@DisplayName("3. 송금 견적서를 갖고 오는 API")
	fun 송금견적서를만든다() {
		// given
		val userData = UserLoginRequestDto().apply {
			userId       = "juniza82@gmail.com" // 이메일 형식을 사용해주세요
			password     = "juniza82"           // 패스워드
		}

		// when
		val resultSignUpDto = userService.postLogin(userData)

		// then
		mockMvc.post("/transfer/quote") {
			contentType = MediaType.APPLICATION_JSON
			header("Authorization", resultSignUpDto.token)
			param("amount", "300000")
			param("targetCurrency", "USD")
		}.andExpect {
			status { isOk() }
		}.andDo { print() }

		mockMvc.post("/transfer/quote") {
			contentType = MediaType.APPLICATION_JSON
			header("Authorization", resultSignUpDto.token)
			param("amount", "200000")
			param("targetCurrency", "JPY")
		}.andExpect {
			status { isOk() }
		}.andDo { print() }

	}

	@Test
	@DisplayName("4. 송금 접수 요청 API")
	fun 송금접수요청() {
		// given
		// @BeforeEach 에 회원가입을 한명 시킨다.
		val userData = UserLoginRequestDto().apply {
			userId       = "juniza82@gmail.com" // 이메일 형식을 사용해주세요
			password     = "juniza82"           // 패스워드
		}

		// when
		val resultSignUpDto = userService.postLogin(userData)

		// when
		mockMvc.post("/transfer/quote") {
			contentType = MediaType.APPLICATION_JSON
			header("Authorization", resultSignUpDto.token)
			param("amount", "300000")
			param("targetCurrency", "USD")
		}.andExpect {
			status { isOk() }
		}.andDo { print() }

		mockMvc.post("/transfer/quote") {
			contentType = MediaType.APPLICATION_JSON
			header("Authorization", resultSignUpDto.token)
			param("amount", "200000")
			param("targetCurrency", "USD")
		}.andExpect {
			status { isOk() }
		}.andDo { print() }

		mockMvc.post("/transfer/request") {
			contentType = MediaType.APPLICATION_JSON
			header("Authorization", resultSignUpDto.token)
			param("quoteId", "2")
		}.andExpect {
			status { isOk() }
		}.andDo { print() }

	}

	@Test
	@DisplayName("5. 회원의 거래 이력을 가지고 오는 API")
	fun 회원의거래이력을가지고온다() {
		// given
		// @BeforeEach 에 회원가입을 한명 시킨다.
		val userData = UserLoginRequestDto().apply {
			userId       = "juniza82@gmail.com" // 이메일 형식을 사용해주세요
			password     = "juniza82"           // 패스워드
		}

		// when
		val resultSignUpDto = userService.postLogin(userData)

		// when
		mockMvc.post("/transfer/quote") {
			contentType = MediaType.APPLICATION_JSON
			header("Authorization", resultSignUpDto.token)
			param("amount", "300000")
			param("targetCurrency", "USD")
		}.andExpect {
			status { isOk() }
		}.andDo { print() }

		mockMvc.post("/transfer/quote") {
			contentType = MediaType.APPLICATION_JSON
			header("Authorization", resultSignUpDto.token)
			param("amount", "200000")
			param("targetCurrency", "JPY")
		}.andExpect {
			status { isOk() }
		}.andDo { print() }

		mockMvc.post("/transfer/request") {
			contentType = MediaType.APPLICATION_JSON
			header("Authorization", resultSignUpDto.token)
			param("quoteId", "2")
		}.andExpect {
			status { isOk() }
		}.andDo { print() }

		mockMvc.post("/transfer/quote") {
			contentType = MediaType.APPLICATION_JSON
			header("Authorization", resultSignUpDto.token)
			param("amount", "100000")
			param("targetCurrency", "USD")
		}.andExpect {
			status { isOk() }
		}.andDo { print() }

		mockMvc.post("/transfer/quote") {
			contentType = MediaType.APPLICATION_JSON
			header("Authorization", resultSignUpDto.token)
			param("amount", "200000")
			param("targetCurrency", "JPY")
		}.andExpect {
			status { isOk() }
		}.andDo { print() }

		mockMvc.post("/transfer/quote") {
			contentType = MediaType.APPLICATION_JSON
			header("Authorization", resultSignUpDto.token)
			param("amount", "100000")
			param("targetCurrency", "JPY")
		}.andExpect {
			status { isOk() }
		}.andDo { print() }

		mockMvc.post("/transfer/request") {
			contentType = MediaType.APPLICATION_JSON
			header("Authorization", resultSignUpDto.token)
			param("quoteId", "5")
		}.andExpect {
			status { isOk() }
		}.andDo { print() }

		// when
		mockMvc.get("/transfer/list") {
			contentType = MediaType.APPLICATION_JSON
			header("Authorization", resultSignUpDto.token)
		}.andExpect {
			status { isOk() }
		}.andDo { print() }

	}*/
}
