package com.skell.spring.skell.api.proxy.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.ArrayList

data class SkellConcordanceResponse(

    @JsonProperty("Lines")
    var lines: Collection<SkellConcordanceLine>?
) {
}