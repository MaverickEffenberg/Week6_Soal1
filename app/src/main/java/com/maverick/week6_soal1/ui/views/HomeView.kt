package com.maverick.week6_soal1.ui.views

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.maverick.week6_soal1.R

@Composable
fun HomeView(navController: NavHostController, viewModel: HomeViewModel = viewModel()) {
    val deals = viewModel.deals

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFD7D7D7))
            .padding(16.dp)
            .padding(top = 20.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Taste the world at your Door Step!",
                fontSize = 24.sp,
                modifier = Modifier.width(180.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(50.dp)
            )
        }

        Spacer(Modifier.height(10.dp))

        // Search
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB04A89), RoundedCornerShape(30.dp))
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "What are you craving?",
                color = Color.White,
                modifier = Modifier.weight(1f),
                fontSize = 13.sp
            )
            Icon(Icons.Default.Search, contentDescription = null, tint = Color.White)
        }

        Spacer(Modifier.height(20.dp))

        // Cards
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            deals.forEach { deal ->
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            when (deal.title) {
                                "Food delivery" -> navController.navigate("FoodDelivery")
                                "Pandamart" -> navController.navigate("Pandamart")
                            }
                        },
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(4.dp),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp, vertical = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(deal.title, fontWeight = FontWeight.Bold)
                        Text(deal.subtitle, fontSize = 10.sp)
                        Image(
                            painter = painterResource(deal.imageRes),
                            contentDescription = deal.title,
                            modifier = Modifier.size(120.dp)
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(20.dp))
        Text("Restaurant Available Now!", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        Image(
            painter = painterResource(id = viewModel.featuredRestaurantImage),
            contentDescription = "Restaurant",
            modifier = Modifier.fillMaxWidth().height(220.dp),
            contentScale = ContentScale.FillWidth
        )
    }
}
