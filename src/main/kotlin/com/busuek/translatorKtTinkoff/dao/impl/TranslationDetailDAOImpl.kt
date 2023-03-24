package com.busuek.translatorKtTinkoff.dao.impl

import com.busuek.translatorKtTinkoff.dao.TranslationDetailDAO
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class TranslationDetailDAOImpl(val jdbcTemplate: JdbcTemplate): TranslationDetailDAO {

    @Transactional
    override fun saveAll(details: List<String>) {
        TODO("Not yet implemented")
    }
}