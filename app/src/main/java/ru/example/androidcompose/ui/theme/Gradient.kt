package ru.example.androidcompose.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val backgroundColor1 = Color(0xFF49ABE9)
val backgroundColor2 = Color(0xFF7A6EEB)
val backgroundGradient = Brush.verticalGradient(
    colors = listOf(
        backgroundColor1,
        backgroundColor2
    )
)

val buttonColor1 = Color(0xFF16BAD6)
val buttonColor2 = Color(0xFF3BD1C8)
val buttonGradient = Brush.horizontalGradient(
    colors = listOf(
        buttonColor1,
        buttonColor2
    )
)