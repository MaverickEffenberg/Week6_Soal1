package com.maverick.week6_soal1.ui.views

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.maverick.week6_soal1.R

@Composable
fun PandamartView(navController: NavHostController, viewModel: PandamartViewModel = viewModel()) {
    val products = viewModel.featuredProducts

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFD7D7D7))
    ) {
        // Header Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB04A89))
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.navigate("Home") }
            )

            Text(
                text = "Vegetables",
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )

            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Cart",
                tint = Color.White
            )
        }

        Spacer(Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Find Your", fontSize = 25.sp)
            Text("Favourite Food", fontSize = 25.sp)
        }


        Spacer(Modifier.height(16.dp))

        // Search Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color(0xFFB04A89), RoundedCornerShape(30.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
            Spacer(Modifier.width(8.dp))
            Text(
                text = "Search for Vegetables",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
        }

        Spacer(Modifier.height(20.dp))

        // Featured products
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Featured Products", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text("View More", fontSize = 12.sp, color = Color.Gray)
        }

        Spacer(Modifier.height(10.dp))

        // Product grid
        for (chunk in products.chunked(2)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                chunk.forEach { product ->
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
                                painter = painterResource(id = product.imageRes),
                                contentDescription = product.name,
                                modifier = Modifier.size(120.dp)
                            )
                            Text(product.name, fontWeight = FontWeight.Bold)
                            Text(product.price, fontSize = 10.sp, color = Color.Red)
                        }
                    }
                }
            }
            Spacer(Modifier.height(20.dp))
        }

        // Discount Banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Gray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.discount),
                contentDescription = "Discount Banner",
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 110.dp, top = 80.dp)
            ) {
                Text("20% off on your", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text("first purchase", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
