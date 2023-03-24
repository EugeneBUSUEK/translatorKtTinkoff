package com.busuek.translatorKtTinkoff.controller

import com.busuek.translatorKtTinkoff.dto.request.TranslateStringDTO
import com.busuek.translatorKtTinkoff.dto.response.TranslateResultDTO
import com.busuek.translatorKtTinkoff.helper.concatString
import com.busuek.translatorKtTinkoff.helper.splitString
import com.busuek.translatorKtTinkoff.service.TranslationResultService
import com.busuek.translatorKtTinkoff.service.YandexTranslateWebClientService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("translator/v1")
class TranslationController(private val yandexTranslateWebClientService: YandexTranslateWebClientService, val translationResultService: TranslationResultService) {
    @PostMapping
    fun translateString(@RequestBody dto: TranslateStringDTO, request: HttpServletRequest): ResponseEntity<TranslateResultDTO> {
        val source = dto.sourceString
        val options = dto.translationOptions
        val ipAddress = request.remoteAddr

        val sourceWords = splitString(source, " ")
        val splitOptions = splitString(options, "-")

        val translatedWords = yandexTranslateWebClientService.getTranslatedWords(splitOptions[1], sourceWords)

        translationResultService.saveTranslateResult(sourceWords, translatedWords, splitOptions, ipAddress)

        val resultText = concatString(translatedWords)
        return ResponseEntity.ok().body(TranslateResultDTO(resultText))
    }
}