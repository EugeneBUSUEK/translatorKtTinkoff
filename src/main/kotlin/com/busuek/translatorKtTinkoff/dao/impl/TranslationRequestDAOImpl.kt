package com.busuek.translatorKtTinkoff.dao.impl

import com.busuek.translatorKtTinkoff.dao.TranslationRequestDAO
import com.busuek.translatorKtTinkoff.entity.TranslationRequest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class TranslationRequestDAOImpl(val jdbcTemplate: JdbcTemplate): TranslationRequestDAO {

    @Transactional
    override fun save(translationReq: TranslationRequest) {
        TODO("Not yet implemented")
    }
}