package com.example.vesta.ext

fun String.cleanHtml(): String {
   val cleanString = this.replace(Regex("<[^>]*>"), "")

   return  cleanString
        .replace("&lt;", "<")
        .replace("&gt;", ">")
        .replace("&quot;", "\"")
        .replace("&apos;", "'")
        .replace("&amp;", "&")
        .replace("&nbsp;", " ")
        .replace("\\<.*?\\>".toRegex(), "")
        .replace("\\r\\n".toRegex(), "\n")
        .replace("\n\n\n\n", "\n")
        .replace("\n\n\n", "\n")
        .trim()
}