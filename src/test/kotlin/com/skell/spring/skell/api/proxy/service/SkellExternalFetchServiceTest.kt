package com.skell.spring.skell.api.proxy.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.skell.spring.skell.api.proxy.dto.SkellConcordanceResponse
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths

class SkellExternalFetchServiceTest {


    @Test
    fun testSerialization() {

        println("My text in a text file!")
//        println(getJsonText())

        val json = getJsonText()

//        val mapper = jacksonObjectMapper()

        val mapper = ObjectMapper().registerKotlinModule()

//        val skellConcordanceResponse: SkellConcordanceResponse = mapper.readValue<SkellConcordanceResponse>(json)

        println("Success")


    }

    fun getJsonText(): String {
        val jsonPathStr = "/Users/alex/Documents/Development/2023/Kotlin/Skell/spring-skell-api-proxy/src/test/resources/skell.json"
        val json = Files.readString(
            Paths.get(jsonPathStr)
        )

        return json
    }


}