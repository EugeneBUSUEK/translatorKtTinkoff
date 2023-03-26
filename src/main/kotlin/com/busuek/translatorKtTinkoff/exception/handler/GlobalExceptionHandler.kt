package com.busuek.translatorKtTinkoff.exception.handler

import com.busuek.translatorKtTinkoff.exception.IncorrectInputException
import com.busuek.translatorKtTinkoff.mapper.errorToEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.NoHandlerFoundException
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

class GlobalExceptionHandler: ResponseEntityExceptionHandler() {
    override fun handleHttpMediaTypeNotSupported(
        ex: HttpMediaTypeNotSupportedException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        return errorToEntity(HttpStatus.UNSUPPORTED_MEDIA_TYPE, ex.message, request)
    }

    override fun handleMissingServletRequestParameter(
        ex: MissingServletRequestParameterException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        return errorToEntity(HttpStatus.BAD_REQUEST, ex.message, request)
    }

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        return errorToEntity(HttpStatus.BAD_REQUEST, ex.message, request)
    }

    override fun handleHttpMessageNotReadable(
        ex: HttpMessageNotReadableException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        return errorToEntity(HttpStatus.BAD_REQUEST, ex.message, request)
    }

    override fun handleNoHandlerFoundException(
        ex: NoHandlerFoundException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        return errorToEntity(HttpStatus.BAD_REQUEST, ex.message, request)
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    protected fun handleMethodArgumentTypeMismatch(
        e: MethodArgumentTypeMismatchException, request: WebRequest?
    ): ResponseEntity<Any>? {
        return errorToEntity(HttpStatus.BAD_REQUEST, e.message, request)
    }

    @ExceptionHandler(IncorrectInputException::class)
    fun handleIncorrectInputException(
        e: IncorrectInputException, request: WebRequest?
    ): ResponseEntity<Any> {
        return errorToEntity(HttpStatus.BAD_REQUEST, e.message, request)
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(
        e: RuntimeException, request: WebRequest?
    ): ResponseEntity<Any>? {
        return errorToEntity(HttpStatus.INTERNAL_SERVER_ERROR, e.message, request)
    }
}