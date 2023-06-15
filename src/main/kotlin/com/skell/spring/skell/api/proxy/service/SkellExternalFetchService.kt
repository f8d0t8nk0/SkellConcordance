package com.skell.spring.skell.api.proxy.service

import com.skell.spring.skell.api.proxy.dto.SkellConcordanceResponse
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder
import org.springframework.http.MediaType
import reactor.core.publisher.Mono

@Service
class SkellExternalFetchService(
        @Qualifier("skellWebClient")
        private val webClient: WebClient
) {

    @Value("\${skell.path}")
    lateinit var skellPath: String

    fun getSkellResult(word: String): Mono<SkellConcordanceResponse> {
        return webClient.get()
                .uri { usiBuilder: UriBuilder ->
                    usiBuilder.path(skellPath)
                            .queryParam("query", word)
                            .queryParam("lang", "English")
                            .queryParam("format", "json")
                            .build()
                }
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
//                .bodyToMono(SkellConcordanceResponse::class.java)
                .bodyToMono(SkellConcordanceResponse::class.java)
    }
}