package com.example.smartcompanion.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color

// Use the colors you defined in Color.kt
private val DarkColorScheme = darkColorScheme(
        primary = GoldAccent,       // Your Gold color for buttons
        secondary = MidnightBlue,   // Dark blue
        tertiary = TextGray,        // Gray for secondary text
        background = MidnightBlue,  // Background of the app
        surface = CardBackground,   // Background for Cards
        onPrimary = Color.Black,    // Text color on top of gold buttons
        onBackground = Color.White, // Text color on the midnight background
        onSurface = Color.White     // Text color inside cards
    )

private val LightColorScheme = lightColorScheme(
    primary = GoldAccent,
    secondary = MidnightBlue,
    tertiary = TextGray,
    background = Color.White,
    surface = Color(0xFFF5F5F5)
)

@Composable
fun SmartCompanionTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}