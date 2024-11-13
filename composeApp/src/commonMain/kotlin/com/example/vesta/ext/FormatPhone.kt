package com.example.vesta.ext

fun String?.formatPhone(): String? {
    val cleanPhone = this?.replace(Regex("[^\\d]"), "")

    return if (cleanPhone != null && cleanPhone.length == 10) {
        "+7 (${cleanPhone.substring(0, 3)}) ${cleanPhone.substring(3, 6)}-${cleanPhone.substring(6, 8)}-${cleanPhone.substring(8)}"
    } else {
        null
    }
}