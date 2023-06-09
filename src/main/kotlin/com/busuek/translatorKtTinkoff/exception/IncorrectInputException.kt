package com.busuek.translatorKtTinkoff.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class IncorrectInputException(message: String) : RuntimeException(message) {
}