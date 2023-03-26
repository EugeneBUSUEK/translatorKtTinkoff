package com.busuek.translatorKtTinkoff.dto.response

class YandexTranslatedWordDTO(val text: String, val detectedLanguageCode: String) {
    constructor() : this("", "")
}