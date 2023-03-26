package com.busuek.translatorKtTinkoff.service.impl

import com.busuek.translatorKtTinkoff.constants.ErrorMessage
import com.busuek.translatorKtTinkoff.constants.TranslateApi
import com.busuek.translatorKtTinkoff.dto.request.YandexTranslateDTO
import com.busuek.translatorKtTinkoff.dto.response.YandexTranslateResultDTO
import com.busuek.translatorKtTinkoff.exception.YandexTranslateApiException
import com.busuek.translatorKtTinkoff.service.YandexTranslateWebClientService
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Service
class YandexTranslateWebClientServiceImpl(
    @Value("\${yandex.api.token}")
    private val token: String,

    @Value("\${yandex.folder.id}")
    private val folderId: String
) : YandexTranslateWebClientService {


    override fun getTranslatedWords(targetLanguageCode: String, sourceWords: List<String>): List<String> {
        val template = YandexTranslateDTO(folderId, sourceWords, targetLanguageCode)
        val client = WebClient.create(TranslateApi.YANDEX_API)

        val result = client.post()
            .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
            .accept(APPLICATION_JSON)
            .body(BodyInserters.fromValue(template))
            .retrieve()
            .bodyToMono<YandexTranslateResultDTO>()
            .blockOptional()
            .orElseThrow { YandexTranslateApiException(ErrorMessage.YANDEX_SERVER_ERROR) }

        return result.translations.map { it.text }.toList()
    }
}