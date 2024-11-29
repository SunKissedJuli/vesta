package com.example.vesta.ext

fun String.imageFromHtml(): List<String> {
    val decodedInput = this
        .replace("&lt;", "<")
        .replace("&gt;", ">")
        .replace("&quot;", "\"")
        .replace("&amp;", "&")
    val regex = Regex("""<img src=["'](https://[^"']*)["'][^>]*>""")
    return regex.findAll(decodedInput).mapNotNull { it.groups[1]?.value }.toList()
}