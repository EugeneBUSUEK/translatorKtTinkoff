package com.busuek.translatorKtTinkoff.exception.data

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.http.HttpStatus
import java.text.DateFormat
import java.util.*

data class ApiError(
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = com.busuek.translatorKtTinkoff.constants.DateFormat.API_ERROR_FORMAT
    )
    private val timestamp: Date,
    private val status: Int,
    private val error: HttpStatus,
    private val message: String?,
    private val path: String
)
