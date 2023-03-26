package com.busuek.translatorKtTinkoff.database.dao.impl

import com.busuek.translatorKtTinkoff.database.dao.TranslationDetailDAO
import com.busuek.translatorKtTinkoff.database.entity.TranslationDetail
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class TranslationDetailDAOImpl(val jdbcTemplate: JdbcTemplate) : TranslationDetailDAO {

    @Transactional
    override fun saveAll(details: List<TranslationDetail>) {

        val query: String = "INSERT INTO translation_result_details " +
                "(source_word, translated_word, translation_result_id)" +
                "VALUES (?, ?, ?)"

        for (detail in details) {
            jdbcTemplate.update(query, detail.sourceWord, detail.translatedWord, detail.translationResultId)
        }
    }

}