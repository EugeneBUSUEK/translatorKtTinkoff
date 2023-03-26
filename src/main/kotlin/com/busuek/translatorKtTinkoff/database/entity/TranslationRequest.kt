package com.busuek.translatorKtTinkoff.database.entity

import java.sql.Date

data class TranslationRequest(
    val id: Long,
    var sourceLanguageCode: String,
    var targetLanguageCode: String,
    var ipAddress: String,
    var requestDate: Date
) {
    constructor(sourceLanguageCode: String, targetLanguageCode: String, ipAddress: String, requestDate: Date) : this(
        0,
        "",
        "",
        "",
        Date(System.currentTimeMillis())
    ) {
        this.sourceLanguageCode = sourceLanguageCode
        this.targetLanguageCode = targetLanguageCode
        this.requestDate = requestDate
        this.ipAddress = ipAddress
    }

//    constructor(sourceLanguageCode: String, targetLanguageCode: String, ipAddress: String, requestDate: Date) : this()
}
