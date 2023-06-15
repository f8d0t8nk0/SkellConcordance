package com.skell.spring.skell.api.proxy.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class SkellConcordanceLineItem(

    @JsonProperty("Str")
    var str: String?,

    @JsonProperty("Class")
    var clazz: String?
) {
}