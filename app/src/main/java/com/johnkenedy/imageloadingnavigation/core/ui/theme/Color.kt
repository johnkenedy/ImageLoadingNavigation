package com.johnkenedy.imageloadingnavigation.core.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val ErrorStart = Color(0xFFFFE9EE)
val ErrorEnd = Color(0xFFFFFBFC)
val LoadingStart = Color(0xFFDAEEFF)
val LoadingEnd = Color(0xFFEDF7FF)
val LoadingIndicatorBlue = Color(0xFF2196F3)

val ColorScheme.loadingGradient: Brush
    get() = verticalGradient(
        colors = listOf(
            LoadingStart,
            LoadingEnd
        )
    )

val ColorScheme.errorGradient: Brush
    get() = verticalGradient(
        colors = listOf(
            ErrorStart,
            ErrorEnd
        )
    )

