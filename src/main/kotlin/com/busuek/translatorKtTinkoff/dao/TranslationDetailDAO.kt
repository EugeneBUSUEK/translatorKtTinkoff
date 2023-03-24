package com.busuek.translatorKtTinkoff.dao

interface TranslationDetailDAO {
    fun saveAll(details: List<String>)
}