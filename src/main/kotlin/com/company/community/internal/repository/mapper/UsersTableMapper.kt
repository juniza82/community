package com.company.community.internal.repository.mapper

import org.apache.ibatis.annotations.Mapper

@Mapper
interface UsersTableMapper {

//    fun insertKeywordSearchHistory(dto: KeywordSearchHistoryDto)
//    fun insertOrUpdatePropertyIdCount(dto: PropertyIdClickedCountInsertDto)

    fun selectUsersTotalCnt(): Int

}