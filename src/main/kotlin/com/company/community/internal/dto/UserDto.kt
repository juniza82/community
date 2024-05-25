package com.company.community.internal.dto

class UserDto(
    var userId: Int = 0,
    var userName: String? = null,
    var password: String? = null,
    var gender: String? = null,
    var age: Int? = null,
    var eMail: String? = null,
    var phone: String? = null,
    var grade: String? = null,
    var createdAt: String? = null,
    var createdId: Int = 0,
    var createdName: String? = null,
    var modifiedAt: String? = null,
    var modifiedId: Int = 0,
    var modifiedName: String? = null,
    var deletedAt: String? = null,
    var deletedFlg: String? = null,
)

