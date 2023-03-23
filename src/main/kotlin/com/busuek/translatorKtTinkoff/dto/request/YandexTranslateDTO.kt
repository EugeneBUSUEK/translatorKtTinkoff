package com.busuek.translatorKtTinkoff.dto.request

class YandexTranslateDTO(val folderId: String, val texts: List<String>, val targetLanguageCode: String) {
    constructor(): this("", listOf(), "")
}