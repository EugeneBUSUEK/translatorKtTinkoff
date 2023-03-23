package com.busuek.translatorKtTinkoff.dto.response

class YandexTranslateResultDTO(val translations: List<YandexTranslatedWordDTO>) {
    constructor(): this(listOf())
}