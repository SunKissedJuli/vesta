package com.example.vesta.ext

fun String.formatCost(): String {

    val number = this.toDoubleOrNull() ?: return this
    return if (number % 1.0 == 0.0) {
        number.toInt().toString()
    } else {
        val roundedNumber = (number * 100).toInt() / 100.00
        "${roundedNumber}0"
    }
}