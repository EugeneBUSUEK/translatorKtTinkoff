package com.busuek.translatorKtTinkoff.support.mapper

import com.busuek.translatorKtTinkoff.exception.data.ApiError
import com.busuek.translatorKtTinkoff.support.helper.getCurrentDate
import com.busuek.translatorKtTinkoff.support.helper.getServletPath
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.context.request.WebRequest

fun errorToEntity(status: HttpStatus, message: String?, request: WebRequest?): ResponseEntity<Any> = ResponseEntity(
    ApiError(
        getCurrentDate(), status.value(), status, message, getServletPath(request)
    ), status
)