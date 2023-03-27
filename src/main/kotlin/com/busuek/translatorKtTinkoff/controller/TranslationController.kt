package com.busuek.translatorKtTinkoff.controller

import com.busuek.translatorKtTinkoff.dto.request.TranslateStringDTO
import com.busuek.translatorKtTinkoff.dto.response.TranslateResultDTO
import com.busuek.translatorKtTinkoff.service.TranslationService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("translator/v1")
class TranslationController(
    private val translationService: TranslationService
) {
    @PostMapping
    fun translateString(
        @RequestBody dto: TranslateStringDTO,
        request: HttpServletRequest
    ): ResponseEntity<TranslateResultDTO> =
        ResponseEntity.ok().body(TranslateResultDTO(translationService.executeTranslate(dto, request)))
}