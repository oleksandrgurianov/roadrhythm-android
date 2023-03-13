package com.example.roadrhythm.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.roadrhythm.R

val AvenirNextBold = FontFamily(Font(R.font.avenir_next_bold))
val AvenirNextRegular = FontFamily(Font(R.font.avenir_next_regular))

val Typography = Typography(
    h1 = TextStyle(
        color = Color.White,
        fontFamily = AvenirNextBold,
        fontSize = 36.sp
    ),
    h2 = TextStyle(
        color = Color.White,
        fontFamily = AvenirNextBold,
        fontSize = 24.sp
    ),
    subtitle1 = TextStyle(
        color = Color.White,
        fontFamily = AvenirNextRegular,
        fontWeight = FontWeight.Thin,
        fontSize = 20.sp
    ),
    body1 = TextStyle(
        color = Color.White,
        fontFamily = AvenirNextBold,
        fontSize = 16.sp
    )
)