package com.example.vesta.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColorScheme(
    primary = ButtonColor,
    secondary = SearchBarColor,
    secondaryContainer = LightGray,
    background = White,
    onSecondary = Color.Black,
    onTertiary = MainAccentColor,
    tertiary = BackgroundGray,
    tertiaryContainer = SubAccentColor,
    onSecondaryContainer = ButtonGray
)

private val LightColorPalette = lightColorScheme(
    primary = ButtonColor,
    secondary = SearchBarColor,
    secondaryContainer = LightGray,
    background = White,
    onSecondary = Color.Black,
    onTertiary = MainAccentColor,
    tertiary = BackgroundGray,
    tertiaryContainer = SubAccentColor,
    onSecondaryContainer = ButtonGray
)

@Composable
fun VestaTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = LightColorPalette


    MaterialTheme(
        colorScheme = colors,
        typography = Material2Typography,
        content = content
    )
}