package com.example.smartcompanion.ui.theme.ViewModel



import android.app.Application
import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.smartcompanion.Data.Department
import com.example.smartcompanion.ui.theme.Screens.LoginScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val prefs = application.getSharedPreferences("campus_prefs", Context.MODE_PRIVATE)

    var isLoggedIn by mutableStateOf(prefs.getBoolean("isLoggedIn", false))
    var isLoading by mutableStateOf(false)
    var loginError by mutableStateOf<String?>(null)

    fun login(user: String, pass: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            isLoading = true
            loginError = null
            delay(1500) // Mock loading delay

            if (user == "admin" && pass == "1234") {
                prefs.edit().putBoolean("isLoggedIn", true).apply()
                isLoggedIn = true
                onSuccess()
            } else {
                loginError = "Invalid credentials!"
            }
            isLoading = false
        }
    }

    fun logout() {
        prefs.edit().clear().apply()
        isLoggedIn = false
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    // Wrap it in your actual theme name
    com.example.smartcompanion.ui.theme.SmartCompanionTheme {
        val navController = rememberNavController()

        // If the preview is still white, it's because of this line:
        // Try commenting out the viewModel logic inside LoginScreen to test.
        val viewModel: AuthViewModel = viewModel()

        LoginScreen(navController = navController, viewModel = viewModel)
    }
}
