package com.busuek.translatorKtTinkoff.database.dao

import com.busuek.translatorKtTinkoff.database.entity.TranslationDetail

interface TranslationDetailDAO {
    fun saveAll(details: List<TranslationDetail>)
}