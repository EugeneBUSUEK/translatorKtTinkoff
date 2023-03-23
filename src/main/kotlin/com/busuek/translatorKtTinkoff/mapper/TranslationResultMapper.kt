package com.busuek.translatorKtTinkoff.mapper

import com.busuek.translatorKtTinkoff.entity.TranslationDetail
import com.busuek.translatorKtTinkoff.entity.TranslationRequest
import java.sql.Date
import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.streams.toList

fun mapToTranslationRequest(options: List<String>, ipAddress: String, requestDate: Date): TranslationRequest {
    return TranslationRequest(options[0], options[1], ipAddress, requestDate)
}

fun mapToTranslationDetail(sourceWords: List<String>,translatedWords: List<String>,resultId: Long): List<TranslationDetail> {
    for (i in sourceWords.iterator()) {

    }
    return (0 until sourceWords.size)
        .map{TranslationDetail(sourceWords[it], translatedWords[it], resultId)}
        .toList()
}