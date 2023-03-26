package com.busuek.translatorKtTinkoff.support.mapper

import com.busuek.translatorKtTinkoff.database.entity.TranslationDetail
import com.busuek.translatorKtTinkoff.database.entity.TranslationRequest
import java.sql.Date
import java.util.stream.IntStream

fun mapToTranslationRequest(options: List<String>, ipAddress: String, requestDate: Date): TranslationRequest {
    return TranslationRequest(options[0], options[1], ipAddress, requestDate)
}

fun mapToTranslationDetail(sourceWords: List<String>,translatedWords: List<String>,resultId: Long): List<TranslationDetail> {
//    for (i in sourceWords.iterator()) {
//
//    }
    val rs: List<TranslationDetail> = IntStream.range(0, sourceWords.size)
        .mapToObj { TranslationDetail(sourceWords[it], translatedWords[it], resultId) }
        .toList()
    return rs
}