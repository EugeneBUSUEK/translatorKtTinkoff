package com.busuek.translatorKtTinkoff.database.dao.impl

import com.busuek.translatorKtTinkoff.database.dao.TranslationRequestDAO
import com.busuek.translatorKtTinkoff.database.entity.TranslationRequest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.sql.PreparedStatement
import java.sql.Statement

@Repository
class TranslationRequestDAOImpl(val jdbcTemplate: JdbcTemplate) : TranslationRequestDAO {

    @Transactional
    override fun save(translationReq: TranslationRequest): Long {
        val query: String = "INSERT INTO translation_results " +
                "(source_language_code, target_language_code, ip_address, request_date) " +
                "VALUES (?, ?, ?, ?)"
        val keyHolder: KeyHolder = GeneratedKeyHolder()

        jdbcTemplate.update({
            val ps: PreparedStatement = it.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)

            ps.setString(1, translationReq.sourceLanguageCode)
            ps.setString(2, translationReq.targetLanguageCode)
            ps.setString(3, translationReq.ipAddress)
            ps.setDate(4, translationReq.requestDate)

            ps

        }, keyHolder)

        return keyHolder.key!!.toLong()
    }
}