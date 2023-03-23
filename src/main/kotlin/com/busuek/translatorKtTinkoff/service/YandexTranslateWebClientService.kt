package com.busuek.translatorKtTinkoff.service

interface YandexTranslateWebClientService {
    fun getTranslatedWords(targetLanguageCode: String, sourceWords: List<String>): List<String>
}