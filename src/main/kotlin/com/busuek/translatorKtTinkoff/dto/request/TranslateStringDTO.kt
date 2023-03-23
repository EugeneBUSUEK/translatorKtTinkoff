package com.busuek.translatorKtTinkoff.dto.request

class TranslateStringDTO(val sourceString: String, val translationOptions: String) {
    constructor(): this("", "")
}