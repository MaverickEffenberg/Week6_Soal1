package com.maverick.week6_soal1.ui.views

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class PandaScreen { Home, FoodDelivery, Pandamart }

@Composable
fun PandaApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = PandaScreen.Home.name) {
        composable(PandaScreen.Home.name) { HomeView(navController) }
        composable(PandaScreen.FoodDelivery.name) { DeliveryView(navController) }
        composable(PandaScreen.Pandamart.name) { PandamartView(navController) }
    }
}
