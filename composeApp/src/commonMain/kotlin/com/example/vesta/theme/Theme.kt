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
     secondaryContainer = Gray,
    background = White,
    onSecondary = Color.Black,
    onTertiary = AccentColor,
    tertiary = BackgroundGray
)

private val LightColorPalette = lightColorScheme(
    primary = ButtonColor,
    secondary = SearchBarColor,
    secondaryContainer = Gray,
    background = White,
    onSecondary = Color.Black,
    onTertiary = AccentColor,
    tertiary = BackgroundGray
)

@Composable
fun VestaTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Material2Typography,
        content = content
    )
}