package com.maverick.week6_soal1.ui.views

import androidx.lifecycle.ViewModel
import com.maverick.week6_soal1.R
import com.maverick.week6_soal1.data.models.MenuItem

class PandamartViewModel : ViewModel() {
    val featuredProducts = listOf(
        MenuItem("Fresh Peach", "9$", R.drawable.fresh_peach),
        MenuItem("Avocado", "7$", R.drawable.avocado),
        MenuItem("Pineapple", "5$", R.drawable.pineapple),
        MenuItem("Fresh Broccoli", "3$", R.drawable.fresh_b_roccoli)
    )
}
