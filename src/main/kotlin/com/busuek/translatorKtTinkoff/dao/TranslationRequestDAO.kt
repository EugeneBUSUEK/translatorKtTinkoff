package com.busuek.translatorKtTinkoff.dao

import com.busuek.translatorKtTinkoff.entity.TranslationRequest

interface TranslationRequestDAO {
    fun save(translationReq: TranslationRequest): Long
}