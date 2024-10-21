package com.example.vesta.ext

import androidx.compose.ui.graphics.Color

fun String.rgbToColor(): Color {
    val rgbValues = this.removePrefix("rgb(")
        .removeSuffix(")").split(",")

    val red = rgbValues[0].trim().toInt()
    val green = rgbValues[1].trim().toInt()
    val blue = rgbValues[2].trim().toInt()

    return Color(red, green, blue)
}