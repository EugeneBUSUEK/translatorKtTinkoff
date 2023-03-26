package com.busuek.translatorKtTinkoff.database.dao

import com.busuek.translatorKtTinkoff.database.entity.TranslationRequest

interface TranslationRequestDAO {
    fun save(translationReq: TranslationRequest): Long
}