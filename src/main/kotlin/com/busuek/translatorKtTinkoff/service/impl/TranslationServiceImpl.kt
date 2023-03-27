package com.busuek.translatorKtTinkoff.service.impl

import com.busuek.translatorKtTinkoff.dto.request.TranslateStringDTO
import com.busuek.translatorKtTinkoff.service.TranslationResultService
import com.busuek.translatorKtTinkoff.service.TranslationService
import com.busuek.translatorKtTinkoff.service.YandexTranslateWebClientService
import com.busuek.translatorKtTinkoff.support.helper.checkTranslationRequest
import com.busuek.translatorKtTinkoff.support.helper.concatString
import com.busuek.translatorKtTinkoff.support.helper.splitString
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Service

@Service
class TranslationServiceImpl(
    private val yandexTranslateWebClientService: YandexTranslateWebClientService,
    private val translationResultService: TranslationResultService
) : TranslationService {

    override fun executeTranslate(dto: TranslateStringDTO, request: HttpServletRequest): String {

        val source = dto.sourceString
        val options = dto.translationOptions
        val ipAddress = request.remoteAddr

        checkTranslationRequest(source, options)

        val sourceWords = splitString(source, " ")
        val splitOptions = splitString(options, "-")

        val translatedWords = yandexTranslateWebClientService.getTranslatedWords(splitOptions[1], sourceWords)

        translationResultService.saveTranslateResult(sourceWords, translatedWords, splitOptions, ipAddress)

        return concatString(translatedWords)
    }
}