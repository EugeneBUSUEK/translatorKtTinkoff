package com.busuek.translatorKtTinkoff.support.helper

import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest

fun getServletPath(request: WebRequest?): String = (request as ServletWebRequest).request.servletPath