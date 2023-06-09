package com.example.roadrhythm.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = LightGray,
    primaryVariant = DarkGray,
    secondary = Gray,
    secondaryVariant = Green,
    background = DimGray
)

@Composable
fun RoadRhythmTheme(content: @Composable () -> Unit) {
    val colors = DarkColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}