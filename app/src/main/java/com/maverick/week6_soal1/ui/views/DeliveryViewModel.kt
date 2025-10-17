package com.maverick.week6_soal1.ui.views

import androidx.lifecycle.ViewModel
import com.maverick.week6_soal1.R
import com.maverick.week6_soal1.data.models.MenuItem

class DeliveryViewModel : ViewModel() {

    val popularMenu = listOf(
        MenuItem("Zinger Burger", "2$", R.drawable.zinger_burger),
        MenuItem("Roll Paratha", "3$", R.drawable.roll_paratha),
        MenuItem("Tomatto Soup", "2$", R.drawable.tomatto_soup),
        MenuItem("Long Burger", "5$", R.drawable.long_burger),
        MenuItem("Creamy Biscuit", "5$", R.drawable.creamy_biscut),
        MenuItem("Cupcake", "3$", R.drawable.cupcake)
    )
}
