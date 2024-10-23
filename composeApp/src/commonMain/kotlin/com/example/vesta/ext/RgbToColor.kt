package com.example.vesta.ext

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

fun String.rgbToColor(colorScheme: ColorScheme): Color {
    val rgbValues = this.removePrefix("rgb(")
        .removeSuffix(")").split(",")

    val red = rgbValues[0].trim().toInt()
    val green = rgbValues[1].trim().toInt()
    val blue = rgbValues[2].trim().toInt()

    return when(this){
        "rgb(0, 114, 180)" -> { colorScheme.primary}
        "rgb(86, 132, 174)" -> {  colorScheme.tertiaryContainer}
        "rgb(225, 34, 49)" -> {  colorScheme.onTertiary}
        else -> { Color(red, green, blue)}
    }
}

