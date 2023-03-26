package com.busuek.translatorKtTinkoff.database.entity

import java.sql.Date

data class TranslationDetail(val id: Long, var sourceWord: String, var translatedWord: String, var translationResultId: Long) {
    constructor(sourceWord: String, translatedWord: String, translationResultId: Long): this(0, "", "", 0) {
        this.sourceWord = sourceWord
        this.translatedWord = translatedWord
        this.translationResultId = translationResultId
    }

//    constructor(sourceWord: String, translatedWord: String, translationResultId: Long) : this()
}
