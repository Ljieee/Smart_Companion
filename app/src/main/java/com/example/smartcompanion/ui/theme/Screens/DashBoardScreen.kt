package com.example.smartcompanion.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartcompanion.R

@Composable
fun DashBoardScreen(navController: NavController) {
    Scaffold(
        topBar = {
            // Light Blue Header - University Logo/Text
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFB3E5FC))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "SMART COMPANION",
                    color = Color(0xFF01579B),
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
            // Fixed Bottom Navigation with even alignment
            BottomAppBar(containerColor = Color(0xFFB3E5FC)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* Already Home */ }) {
                        Icon(Icons.Default.Home, "Home", tint = Color(0xFF01579B))
                    }
                    IconButton(onClick = { navController.navigate("profile") }) {
                        Icon(Icons.Default.Person, "Profile", tint = Color(0xFF01579B))
                    }
                    IconButton(onClick = { /* Email/Service */ }) {
                        Icon(Icons.Default.Email, "Service", tint = Color(0xFF01579B))
                    }
                    IconButton(onClick = { navController.navigate("settings") }) {
                        Icon(Icons.Default.Settings, "Settings", tint = Color(0xFF01579B))
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // 1. Background Image with Opacity
            Image(
                painter = painterResource(id = R.drawable.university),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.2f
            )

            // 2. Dashboard Content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Header Row with Dashboard Title and Notification Icon
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            "DASHBOARD",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color(0xFF01579B)
                        )
                        Text(
                            "Welcome back, Student!",
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )
                    }

                    // Notification Icon positioned "upside" of campus info grid
                    IconButton(onClick = { /* Action for notifications */ }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications",
                            tint = Color(0xFF01579B),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Main Dashboard Grid
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    DashboardCard("Announcements", Icons.Default.List)
                    DashboardCard("My Schedule", Icons.Default.Search)
                    DashboardCard("Campus Info", Icons.Default.Info) {
                        navController.navigate("campus_info")
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    "CAMPUS INFORMATION MODULE",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color(0xFF01579B)
                )
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
        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFB3E5FC))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(icon, null, tint = Color(0xFF01579B), modifier = Modifier.size(30.dp))
            Text(
                text = title,
                fontSize = 10.sp,
                color = Color(0xFF01579B),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
    }
}

@Composable
fun ModuleButton(title: String, icon: ImageVector) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF01579B))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, null, tint = Color(0xFF01579B))
            Spacer(modifier = Modifier.width(16.dp))
            Text(title, fontWeight = FontWeight.Medium, color = Color(0xFF01579B))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashBoardScreenPreview() {
    MaterialTheme {
        val navController = rememberNavController()
        DashBoardScreen(navController = navController)
    }
}