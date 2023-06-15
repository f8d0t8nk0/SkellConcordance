package com.skell.spring.skell.api.proxy.config

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Configuration
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean
import org.springframework.http.codec.ClientCodecConfigurer
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.util.MimeType
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import java.nio.charset.StandardCharsets

@Configuration
class WebClientConfig {

        @Value("\${skell.hostname}")
        lateinit var skellHostname: String

        @Bean("skellWebClient")
        fun skellWebClient(): WebClient {
                return WebClient.builder()
                        .baseUrl(skellHostname)
                        .exchangeStrategies(
                                ExchangeStrategies.builder()
                                        .codecs(this::acceptedCodecs)
                                        .build()
                        )
                        .build();
        }


        private fun acceptedCodecs(clientCodecConfigurer: ClientCodecConfigurer) {
                val  plainTextMimeType = MimeType("text", "plain", StandardCharsets.UTF_8)

                val objectMapper = jacksonObjectMapper()
                objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

                clientCodecConfigurer.customCodecs()
                        .register(Jackson2JsonEncoder(objectMapper, plainTextMimeType))
                clientCodecConfigurer.customCodecs()
                        .register(Jackson2JsonDecoder(objectMapper, plainTextMimeType))
        }


}