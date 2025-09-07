package com.example.todotask.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = DarkThemeGreenPrimary,
    secondary = DarkThemeGreenSecondary,
    background = DarkThemeBackground,
    onPrimary = TextOnBackground,
    onSecondary = TextOnBackground,
    onBackground = TextOnDarkBackground,
    surface = DarkThemeBackground,
    onSurface = TextOnDarkBackground
)

private val LightColorScheme = lightColorScheme(
    primary = GreenPrimary,
    secondary = GreenSecondary,
    background = AppBackground,
    surface = AppBackground,
    onPrimary = TextOnPrimary,
    onSecondary = TextOnPrimary,
    onBackground = TextOnBackground,
    onSurface = TextOnBackground
)

@Composable
fun TodoTaskTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = DarkGreenPrimary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}