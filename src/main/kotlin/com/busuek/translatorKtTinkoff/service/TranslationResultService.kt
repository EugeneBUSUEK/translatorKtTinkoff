package com.busuek.translatorKtTinkoff.service

interface TranslationResultService {
    fun saveTranslateResult(sourceWords: List<String>, translatedWords: List<String>, translateOptions: List<String>, ipAddress: String)
}