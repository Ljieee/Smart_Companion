package com.example.smartcompanion.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartcompanion.ui.theme.ViewModel.AuthViewModel
import androidx.compose.ui.tooling.preview.Preview
import com.example.smartcompanion.R

/**
 * STATEFUL COMPOSABLE
 * Use this in your NavHost. It handles the ViewModel and Navigation logic.
 */
@Composable
fun LoginScreen(navController: NavController, viewModel: AuthViewModel) {
    LoginContent(
        onLoginClick = { email, password ->
            viewModel.login(email, password) {
                navController.navigate("dashboard")
            }
        },
        onSignUpClick = {
            // Add navigation to sign up screen here if needed
            // navController.navigate("signup")
        }
    )
}

/**
 * STATELESS COMPOSABLE
 * Use this for Previews and UI design. It only knows about UI state.
 */
@Composable
fun LoginContent(
    onLoginClick: (String, String) -> Unit,
    onSignUpClick: () -> Unit = {}
) {
    // UI Local State
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEBEBEB))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // 1. University Logo
            Image(
                painter = painterResource(id = R.drawable.smart),
                contentDescription = "University Name",
                modifier = Modifier
                    .height(300.dp)
                    .width(300.dp),
                contentScale = ContentScale.Fit


            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Log in",
                color = Color(0xFF37474F),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 2. Email Field
            Text(
                "Email",
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp),
                color = Color.DarkGray,
                fontSize = 14.sp
            )
            TextField(
                value = user,
                onValueChange = { user = it },
                placeholder = { Text("johndoe@example.com", color = Color.Gray) },
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                shape = RoundedCornerShape(25.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFCCCCCC),
                    focusedContainerColor = Color(0xFFCCCCCC),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 3. Password Field
            Text(
                "Password",
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp),
                color = Color.DarkGray,
                fontSize = 14.sp
            )
            TextField(
                value = pass,
                onValueChange = { pass = it },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                shape = RoundedCornerShape(25.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFCCCCCC),
                    focusedContainerColor = Color(0xFFCCCCCC),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                )
            )

            // 4. Login Button
            Button(
                onClick = { onLoginClick(user, pass) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(55.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF01579B))
            ) {
                Text("Log in", fontSize = 18.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.weight(1f))

            // 5. Footer
            Row(
                modifier = Modifier.padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("No account? ", color = Color.Gray)
                Text(
                    "Sign up",
                    color = Color(0xFF01579B),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onSignUpClick() }
                )
            }
        }
    }
}/**
 * PREVIEW
 * Now points to the Stateless version (LoginContent)
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        // No ViewModel needed here anymore!
        LoginContent(onLoginClick = { _, _ -> })
    }
}