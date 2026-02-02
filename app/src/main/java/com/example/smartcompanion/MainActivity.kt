package com.example.smartconpanion


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartcampus.ui.theme.Screens.CampusInfoScreen
import com.example.smartcompanion.ui.theme.Screens.*
import com.example.smartcompanion.ui.theme.ViewModel.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val authViewModel: AuthViewModel = viewModel()
            val campusViewModel: CampusViewModel = viewModel()
            val navController = rememberNavController()

            val startRoute = if (authViewModel.isLoggedIn) "dashboard" else "login"

            NavHost(navController = navController, startDestination = startRoute) {
                composable("login") {
                    LoginScreen(navController, authViewModel)
                }
                composable("dashboard") {
                    DashBoardScreen(navController)
                }
                // FIX: Pass BOTH navController and campusViewModel
                composable("campus_info") {
                    CampusInfoScreen(navController, campusViewModel)
                }
            }
        }
    }
}