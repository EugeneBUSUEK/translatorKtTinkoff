package com.busuek.translatorKtTinkoff.helper

import java.util.Date

fun getCurrentDate(): Date = Date(System.currentTimeMillis())

fun getCurrentSQLDate(): java.sql.Date = java.sql.Date(System.currentTimeMillis())