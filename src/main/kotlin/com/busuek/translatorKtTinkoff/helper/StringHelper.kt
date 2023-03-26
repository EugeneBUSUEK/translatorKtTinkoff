package com.busuek.translatorKtTinkoff.helper

fun splitString(target: String, regex: String): List<String> {
    return target.trim().split(regex)
}

fun concatString(words: List<String>): String = words.joinToString(" ")