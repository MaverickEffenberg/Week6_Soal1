package com.maverick.week6_soal1.data.models

import androidx.annotation.DrawableRes

data class Product(
    val title: String,
    val price: String,
    @DrawableRes val imageRes: Int
)
