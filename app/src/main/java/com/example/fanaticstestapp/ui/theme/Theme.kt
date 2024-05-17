package com.example.fanaticstestapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val FanaticsColorScheme = darkColorScheme(
    primary = Color.Green,
    onPrimary = Color.Red,
    onSurface = FanWhite,
    surface = FanSurfaceTransparent,

    )


@Composable
fun FanaticsTestAppTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = FanaticsColorScheme

    MaterialTheme(
      colorScheme = colorScheme,
      typography = Typography,
      content = content
    )
}