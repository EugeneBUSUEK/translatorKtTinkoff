package com.busuek.translatorKtTinkoff.service

import com.busuek.translatorKtTinkoff.dto.request.TranslateStringDTO
import jakarta.servlet.http.HttpServletRequest

interface TranslationService {

    fun executeTranslate(dto: TranslateStringDTO, request: HttpServletRequest): String
}