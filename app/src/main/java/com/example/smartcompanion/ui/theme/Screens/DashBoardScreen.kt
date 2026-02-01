package com.example.smartcompanion.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.smartcompanion.R

@Composable
fun DashBoardScreen(navController: NavController) {
    Scaffold(
        topBar = {
            // Light Blue Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFB3E5FC)) // Light Blue background
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "SMART COMPANION",
                    color = Color(0xFF01579B), // Dark Blue text
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "(UNIVERSITY OF LAGUNA)",
                    color = Color(0xFF01579B),
                    fontSize = 12.sp
                )
            }
        },
        bottomBar = {
            BottomAppBar(containerColor = Color(0xFFB3E5FC)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                    Icon(Icons.Default.Home, contentDescription = "Home", tint = Color(0xFF01579B))
                    Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color(0xFF01579B))
                    Icon(Icons.Default.Email, contentDescription = "Service", tint = Color(0xFF01579B))
                    Icon(Icons.Default.Settings, contentDescription = "Settings", tint = Color(0xFF01579B))
                }
            }
        }
    ) { paddingValues ->
        // The Box allows the Image to be BEHIND the Column
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // 1. Background Image
            Image(
                painter = painterResource(id = R.drawable.university), // REPLACE WITH YOUR FILENAME
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.2f // Adjusted to 20% opacity so text is easy to read
            )

            // 2. Dashboard Content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text("DASHBOARD", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp, color = Color(0xFF01579B))
                Text("Welcome back, Student!", fontSize = 14.sp, color = Color.DarkGray)

                Spacer(modifier = Modifier.height(20.dp))

                // Main Dashboard Grid
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    DashboardCard("Announcements", Icons.Default.List)
                    DashboardCard("My Schedule", Icons.Default.Search)
                    DashboardCard("Campus Info", Icons.Default.Info) {
                        navController.navigate("campus_info")
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text("CAMPUS INFORMATION MODULE", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF01579B))
                Spacer(modifier = Modifier.height(12.dp))

                // Large Module Buttons
                ModuleButton("List of Departments", Icons.Default.Menu)
                Spacer(modifier = Modifier.height(8.dp))
                ModuleButton("Contact Information", Icons.Default.Call)
            }
        }
    }
}

@Composable
fun DashboardCard(title: String, icon: ImageVector, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .size(100.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF4CAF50))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(icon, contentDescription = null, tint = Color(0xFF01579B), modifier = Modifier.size(30.dp))
            Text(title, fontSize = 10.sp, color = Color(0xFF01579B), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
        }
    }
}

@Composable
fun ModuleButton(title: String, icon: ImageVector) {
    Card(
        modifier = Modifier.fillMaxWidth().height(80.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF1B5E20))
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = Color(0xFF1B5E20))
            Spacer(modifier = Modifier.width(16.dp))
            Text(title, fontWeight = FontWeight.Medium)
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashBoardScreenPreview() {
    // Wrap it in MaterialTheme so the buttons and text use standard Material styles
    MaterialTheme {
        // Create a dummy navController that won't actually navigate anywhere
        val navController = rememberNavController()

        DashBoardScreen(navController = navController)
    }
}