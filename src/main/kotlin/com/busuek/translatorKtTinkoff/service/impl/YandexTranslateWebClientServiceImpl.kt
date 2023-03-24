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


    val token: String = "t1.9euelZrIiZGbz5aMx8zJzpLOx4nIlO3rnpWazY6LjJuXicqUmoqYyc-Tkpnl8_dwfwhf-e8WPV98_t3z9zAuBl_57xY9X3z-.Qlf1JukfWUirbsfafWzZlJ5StRPUuCd7NtroKHgC_fWESruOEf8dFB_CCVUJZr7tEMw7ierc5yGsN4Ytl52KDQ"

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