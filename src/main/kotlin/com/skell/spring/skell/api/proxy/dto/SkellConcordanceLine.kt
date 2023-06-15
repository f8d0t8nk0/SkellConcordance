package com.skell.spring.skell.api.proxy.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class SkellConcordanceLine(

    @JsonProperty("Left")
    var left: Collection<SkellConcordanceLineItem>?,

    @JsonProperty("Kwic")
    var kwic: Collection<SkellConcordanceLineItem>?,

    @JsonProperty("Right")
    var right: Collection<SkellConcordanceLineItem>?
) {

}
