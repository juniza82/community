package com.company.community

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestPropertySource

@SpringBootTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = ["spring.profiles.active=dev-local"]) // can override any propertysource
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL) // autowire without @autowired
class CommunityApplicationTests {

	@Test
	fun contextLoads() {
		println("a")
	}

}
