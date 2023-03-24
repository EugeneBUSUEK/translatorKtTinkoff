package com.busuek.translatorKtTinkoff.dao

import com.busuek.translatorKtTinkoff.entity.TranslationDetail

interface TranslationDetailDAO {
    fun saveAll(details: List<TranslationDetail>)
}