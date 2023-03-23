package com.busuek.translatorKtTinkoff.entity

import java.sql.Date

data class TranslationDetail(val id: Long, val sourceWord: String, val translatedWord: String, val translationResultId: Long) {
    constructor(): this(0, "", "", 0) {
    }

    constructor(sourceWord: String, translatedWord: String, translationResultId: Long) : this()
}
