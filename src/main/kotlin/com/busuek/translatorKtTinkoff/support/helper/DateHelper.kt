package com.busuek.translatorKtTinkoff.support.helper

import java.util.*

fun getCurrentDate(): Date = Date(System.currentTimeMillis())

fun getCurrentSQLDate(): java.sql.Date = java.sql.Date(System.currentTimeMillis())