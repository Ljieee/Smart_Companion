package com.example.smartcampus.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack // MODERN NON-DEPRECATED ICON
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartcompanion.ui.theme.ViewModel.CampusViewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.smartcompanion.R

@Composable
fun CampusInfoScreen(navController: NavController, viewModel: CampusViewModel) {
    Scaffold(
        topBar = {
            // Header with Return Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFB3E5FC)) // Light Blue Theme
                    .padding(vertical = 8.dp, horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // FIXED: Using AutoMirrored to avoid deprecation warnings
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Return to Dashboard",
                        tint = Color(0xFF01579B)
                    )
                }

                Text(
                    text = "CAMPUS DIRECTORY",
                    color = Color(0xFF01579B),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )

                // Spacer to keep the title perfectly centered
                Spacer(modifier = Modifier.width(48.dp))
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // 1. Background Image (20% Opacity)
            Image(
                painter = painterResource(id = R.drawable.university),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.2f
            )

            // 2. Main List of Departments
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(viewModel.departments) { dept ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White.copy(alpha = 0.85f)
                        ),
                        elevation = CardDefaults.cardElevation(2.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF01579B))
                    ) {
                        ListItem(
                            headlineContent = {
                                Text(dept.name, fontWeight = FontWeight.Bold, color = Color(0xFF01579B))
                            },
                            supportingContent = {
                                Text("Contact: ${dept.contact}", fontSize = 14.sp)
                            },
                            leadingContent = {
                                Icon(dept.icon, contentDescription = null, tint = Color(0xFF01579B))
                            },
                            colors = ListItemDefaults.colors(containerColor = Color.Transparent)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CampusInfoScreenPreview() {
    MaterialTheme {
        val navController = rememberNavController()
        val previewViewModel: CampusViewModel = viewModel()
        CampusInfoScreen(navController = navController, viewModel = previewViewModel)
    }
}