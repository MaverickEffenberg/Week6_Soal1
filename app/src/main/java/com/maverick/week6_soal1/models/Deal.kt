package com.maverick.week6_soal1.data.models

import androidx.annotation.DrawableRes

data class Deal(
    val title: String,
    val subtitle: String,
    val buttonText: String,
    @DrawableRes val imageRes: Int
)
