package com.skell.spring.skell.api.proxy.service

import com.skell.spring.skell.api.proxy.dto.SkellConcordanceResponse
import com.skell.spring.skell.api.proxy.dto.SkellPhrasesResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class SkellResultAggregatorService(
    private val skellExternalFetchService: SkellExternalFetchService
) {

//    fun aggregate(word: String): Mono<SkellPhrasesResponse> {
//        skellExternalFetchService.getSkellResult(word)
//            .map { it }
//    }

//    fun buildSkellPhrasesResponse(
//        concordanceResponse: SkellConcordanceResponse
//    ): SkellPhrasesResponse {
//        concordanceResponse.lines.stream()
//            .map { it.left. + it.kwic + it.right }
//    }
}