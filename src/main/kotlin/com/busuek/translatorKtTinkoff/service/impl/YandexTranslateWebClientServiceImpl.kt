package com.busuek.translatorKtTinkoff.service.impl

import com.busuek.translatorKtTinkoff.dto.request.YandexTranslateDTO
import com.busuek.translatorKtTinkoff.dto.response.YandexTranslateResultDTO
import com.busuek.translatorKtTinkoff.service.YandexTranslateWebClientService
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Service
class YandexTranslateWebClientServiceImpl: YandexTranslateWebClientService {


    val token: String = "t1.9euelZrHx8vNy5iWy4qampiWyY-QyO3rnpWazY6LjJuXicqUmoqYyc-Tkpnl9PcKEA1f-e9dOg6X3fT3Sj4KX_nvXToOlw.P6SKY5oX4SycMSEE0iNxV8brSrue8VFuoFB7hkqjnWSXIZKynzrNUsEOc35yfwLzOVoxd07imrt4GJA0rMQyDw"

    val folderId: String = "b1gpmmgv8etd5678mt5q"

    override fun getTranslatedWords(targetLanguageCode: String, sourceWords: List<String>): List<String> {
        val template = YandexTranslateDTO(folderId, sourceWords, targetLanguageCode)
        val client = WebClient.create("https://translate.api.cloud.yandex.net/translate/v2/translate")

        val result = client.post()
            .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
            .accept(APPLICATION_JSON)
            .body(BodyInserters.fromValue(template))
            .retrieve()
            .bodyToMono<YandexTranslateResultDTO>()
            .blockOptional()
            .orElseThrow()

        return result.translations.map { it.text }.toList()
    }
}