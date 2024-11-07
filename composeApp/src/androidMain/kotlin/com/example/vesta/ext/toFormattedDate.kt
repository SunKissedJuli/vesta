package com.example.vesta.ext

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

@RequiresApi(Build.VERSION_CODES.O)
actual fun String.toFormattedDate(): String{
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

    return try {
        val dateTime = LocalDateTime.parse(this, inputFormatter)
        dateTime.format(outputFormatter)
    } catch (e: DateTimeParseException) {
        this
    }
}