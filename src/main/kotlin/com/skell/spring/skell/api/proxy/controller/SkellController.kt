package com.skell.spring.skell.api.proxy.controller

import com.skell.spring.skell.api.proxy.dto.SkellConcordanceResponse
import com.skell.spring.skell.api.proxy.service.SkellExternalFetchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/skell")
class SkellController(val skellExternalFetchService: SkellExternalFetchService) {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello"
    }

    @GetMapping
    fun fetchSkellResult(@RequestParam word: String): Mono<SkellConcordanceResponse> {
        return skellExternalFetchService.getSkellResult(word)
    }

}