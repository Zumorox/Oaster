package com.cutozmie.oaster.core.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val OasterLightColors = lightColorScheme(
    primary = Color(0xFF2F6BFF),
    onPrimary = Color(0xFFFFFFFF),
    background = Color(0xFFF3F5F7),
    surface = Color(0xFFFFFFFF),
    onBackground = Color(0xFF12151A),
    onSurface = Color(0xFF12151A),
    secondary = Color(0xFF4A5565),
    error = Color(0xFFD92D20)
)

private val OasterDarkColors = darkColorScheme(
    primary = Color(0xFF6EA8FF),
    onPrimary = Color(0xFF081120),
    background = Color(0xFF0E1116),
    surface = Color(0xFF171B22),
    onBackground = Color(0xFFF5F7FA),
    onSurface = Color(0xFFF5F7FA),
    secondary = Color(0xFFB8C0CC),
    error = Color(0xFFF97066)
)

@Composable
fun OasterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) OasterDarkColors else OasterLightColors,
        typography = Typography(),
        content = content
    )
}
