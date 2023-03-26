package com.busuek.translatorKtTinkoff.service.impl

import com.busuek.translatorKtTinkoff.database.dao.TranslationDetailDAO
import com.busuek.translatorKtTinkoff.database.dao.TranslationRequestDAO
import com.busuek.translatorKtTinkoff.database.entity.TranslationDetail
import com.busuek.translatorKtTinkoff.database.entity.TranslationRequest
import com.busuek.translatorKtTinkoff.support.helper.getCurrentSQLDate
import com.busuek.translatorKtTinkoff.support.mapper.mapToTranslationDetail
import com.busuek.translatorKtTinkoff.support.mapper.mapToTranslationRequest
import com.busuek.translatorKtTinkoff.service.TranslationResultService
import org.springframework.stereotype.Service

@Service
class TranslationResultServiceImpl(private val translationRequestDAO: TranslationRequestDAO, private val translationDetailDAO: TranslationDetailDAO): TranslationResultService {
    override fun saveTranslateResult(
        sourceWords: List<String>,
        translatedWords: List<String>,
        translateOptions: List<String>,
        ipAddress: String
    ) {
        val currentDate = getCurrentSQLDate()

        val translationRequest: TranslationRequest = mapToTranslationRequest(translateOptions, ipAddress, currentDate)

        val id = translationRequestDAO.save(translationRequest)

        val translationDetails: List<TranslationDetail> = mapToTranslationDetail(sourceWords, translatedWords, id)

        translationDetailDAO.saveAll(translationDetails)
    }
}