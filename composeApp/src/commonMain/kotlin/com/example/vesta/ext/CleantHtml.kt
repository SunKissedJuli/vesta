package com.example.vesta.ext

fun String.cleanHtml(): String {
   val cleanString = this.replace(Regex("<[^>]*>"), "")

    return cleanString.replace("&nbsp;", " ")
        .replace("&lt;", "<")
        .replace("&gt;", ">")
        .replace("&quot;", "\"")
        .replace("&apos;", "'")
        .replace("&amp;", "&")
        .replace("\\r\\n|\\r|\\n".toRegex(), "\n")
        .replace("\\<.*?\\>".toRegex(), "")
        .trim()
}