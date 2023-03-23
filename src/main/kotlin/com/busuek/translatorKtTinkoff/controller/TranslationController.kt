package com.busuek.translatorKtTinkoff.controller

import com.busuek.translatorKtTinkoff.dto.request.TranslateStringDTO
import com.busuek.translatorKtTinkoff.dto.response.TranslateResultDTO
import com.busuek.translatorKtTinkoff.helper.concatString
import com.busuek.translatorKtTinkoff.helper.splitString
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("translator/v1")
class TranslationController {
    @PostMapping
    fun translateString(@RequestBody dto: TranslateStringDTO, request: HttpServletRequest): ResponseEntity<TranslateResultDTO> {
        val source = dto.sourceString
        val options = dto.translationOptions
        val ipAddress = request.remoteAddr

        val sourceWords = splitString(source, " ")
        val splitOptions = splitString(options, "-")

        //TODO

        val resultText = concatString(sourceWords)
        return ResponseEntity.ok().body(TranslateResultDTO(resultText))
    }
}