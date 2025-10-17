package com.maverick.week6_soal1.ui.views

import androidx.lifecycle.ViewModel
import com.maverick.week6_soal1.R
import com.maverick.week6_soal1.data.models.Deal

class HomeViewModel : ViewModel() {

    val deals = listOf(
        Deal("Food delivery", "Delivery from 99$", "Order Now", R.drawable.food_delivery),
        Deal("Pandamart", "New users $10 off", "Shop Now", R.drawable.pandamart)
    )

    val featuredRestaurantImage = R.drawable.pizza
}
