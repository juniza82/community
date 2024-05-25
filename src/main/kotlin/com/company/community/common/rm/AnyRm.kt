package com.company.community.common.rm

data class AnyRm (
    var data: Any? = mapOf<Any, Any>()
): ParentRm()