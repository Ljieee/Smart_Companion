package com.example.smartcampus.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartcompanion.ui.theme.ViewModel.CampusViewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartcompanion.R // Double check this import matches your project

@Composable
fun CampusInfoScreen(viewModel: CampusViewModel) {
    Scaffold(
        topBar = {
            // Matching the Dashboard Blue Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFB3E5FC)) // Light Blue
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "UNIVERSITY DIRECTORY",
                    color = Color(0xFF01579B), // Dark Blue
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // 1. Background Image (Lowercased to avoid R errors)
            Image(
                painter = painterResource(id = R.drawable.university),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.2f
            )

            // 2. Directory List
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(viewModel.departments) { dept ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f)),
                        elevation = CardDefaults.cardElevation(2.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF01579B))
                    ) {
                        ListItem(
                            colors = ListItemDefaults.colors(containerColor = Color.Transparent),
                            headlineContent = {
                                Text(dept.name, color = Color(0xFF01579B), fontWeight = FontWeight.Bold)
                            },
                            supportingContent = {
                                Text(dept.contact, color = Color.DarkGray)
                            },
                            leadingContent = {
                                Icon(dept.icon, contentDescription = null, tint = Color(0xFF01579B))
                            }
                        )
                    }
                }
            }
        }
    }
}

// --- PREVIEW SECTION ---
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CampusInfoScreenPreview() {
    MaterialTheme {
        // We use the real ViewModel or a mock if you have one
        val previewViewModel: CampusViewModel = viewModel()

        CampusInfoScreen(viewModel = previewViewModel)
    }
}