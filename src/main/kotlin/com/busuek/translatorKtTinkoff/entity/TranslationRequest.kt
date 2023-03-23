package com.busuek.translatorKtTinkoff.entity

import java.sql.Date

data class TranslationRequest(val id: Long, val sourceLanguageCode: String, val targetLanguageCode: String, val ipAddress: String, val requestDate: Date) {
    constructor(): this(0, "", "", "", Date(System.currentTimeMillis())) {
    }

    constructor(sourceLanguageCode: String, targetLanguageCode: String, ipAddress: String, requestDate: Date) : this()
}
