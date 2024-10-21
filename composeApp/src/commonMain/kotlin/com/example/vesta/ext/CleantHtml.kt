package com.example.vesta.ext

fun String.cleanHtml(): String {
    val cleanString = this.replace(Regex("<[^>]*>"), "")
    return cleanString.replace("&nbsp;", " ")
        .replace("&lt;", "<")
        .replace("&gt;", ">")
        .replace("&quot;", "\"")
        .replace("&quot;", "\"")
        .trim()
}