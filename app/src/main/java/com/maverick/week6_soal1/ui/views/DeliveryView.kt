package com.maverick.week6_soal1.ui.views

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.maverick.week6_soal1.R

@Composable
fun DeliveryView(navController: NavHostController, viewModel: DeliveryViewModel = viewModel()) {
    val menuItems = viewModel.popularMenu

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFD7D7D7))
            .padding(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column {
                Text("Find Your", fontSize = 25.sp)
                Text("Favourite Food", fontSize = 25.sp)
            }
            Image(
                painter = painterResource(id = R.drawable.delivery),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
        }

        Spacer(Modifier.height(10.dp))

        // Search Bar with icons
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFB04A89), RoundedCornerShape(30.dp))
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
                Spacer(Modifier.width(8.dp))
                Text("Search for Food", color = Color.White, fontSize = 13.sp)
                Spacer(Modifier.width(8.dp))
                Icon(Icons.Default.Tune, contentDescription = "Filter", tint = Color.White)
            }

            Spacer(Modifier.width(12.dp))

            // Notification icon with dot
            Box(
                modifier = Modifier.size(30.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Notifications",
                    tint = Color(0xFFB04A89),
                    modifier = Modifier.align(Alignment.Center)
                )
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color(0xFFFF5C8D), CircleShape)
                        .offset(x = 6.dp, y = (-2).dp)
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        // Special Deal
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxSize(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFC64977)),
                shape = RoundedCornerShape(5.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Special Deal For", color = Color.White, fontSize = 16.sp)
                        Text("December", color = Color.White, fontSize = 16.sp)
                        Spacer(Modifier.height(8.dp))
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Text("Buy Now", color = Color(0xFFC64977))
                        }
                    }
                }
            }
            Image(
                painter = painterResource(id = R.drawable.special_deal),
                contentDescription = "Special Deal",
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.CenterEnd)
            )
        }

        Spacer(Modifier.height(16.dp))

        // Popular Menu Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Popular Menu", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text("View More", color = Color.Gray, fontSize = 12.sp)
        }

        Spacer(Modifier.height(10.dp))

        // Menu Grid
        for (chunk in menuItems.chunked(2)) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.fillMaxWidth()) {
                chunk.forEach { item ->
                    Card(
                        modifier = Modifier.weight(1f),
                        elevation = CardDefaults.cardElevation(4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(30.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp, vertical = 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = item.imageRes),
                                contentDescription = item.name,
                                modifier = Modifier.size(100.dp)
                            )
                            Text(item.name, fontWeight = FontWeight.Bold)
                            Text(item.price, fontSize = 10.sp, color = Color.Red)
                        }
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}
