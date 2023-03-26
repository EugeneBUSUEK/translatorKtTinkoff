package com.busuek.translatorKtTinkoff.support.helper

import com.busuek.translatorKtTinkoff.constants.ErrorMessage
import com.busuek.translatorKtTinkoff.exception.IncorrectInputException

fun checkTranslationRequest(source: String, options: String) {
    if (source.trim().isEmpty()) {
        throw IncorrectInputException(ErrorMessage.SOURCE_STRING_IS_EMPTY)
    }

    if (options.length > 5) {
        throw IncorrectInputException(ErrorMessage.INCORRECT_TRANSLATION_OPTIONS)
    }

    if (options.length != 5 || options[2] != '-') {
        throw IncorrectInputException(ErrorMessage.INCORRECT_TRANSLATION_OPTIONS)
    }
}