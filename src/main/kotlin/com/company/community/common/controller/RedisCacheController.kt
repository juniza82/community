package com.company.community.common.controller

//import com.yoon.headspa.common.rm.BooleanRm
//import com.yoon.headspa.common.provider.RedisCacheProvider
//import com.yoon.headspa.config.utils.ResponseEntityUtils.Companion.getResponseEntityWithBody
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.DeleteMapping
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//
//@RestController
//@RequestMapping("/redis")
//class RedisCacheController(
//    private val redisCacheProvider: RedisCacheProvider
//) {
//
// 아직 redis 가 없음.
//    @DeleteMapping("/all")
//    fun deleteAllCaches(): ResponseEntity<BooleanRm> {
//        return getResponseEntityWithBody(
//            BooleanRm(
//                data = redisCacheProvider.clearAllRedisCaches()
//            )
//        )
//    }
//
//}