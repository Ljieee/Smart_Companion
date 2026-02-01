package com.example.smartcompanion.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.smartcompanion.R // Ensure this import is correct

@Composable
fun LoginScreen(navController: NavController, viewModel: AuthViewModel) {
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize().background(Color(0xFFEBEBEB))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // 1. University Header (Image + Text)
            // Replace with your actual drawable resource names
            Image(
                painter = painterResource(id = R.drawable.university_logo_text),
                contentDescription = "University Name",
                modifier = Modifier.height(60.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.university_seal),
                contentDescription = "University Seal",
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Log in",
                color = Color(0xFF37474F),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 2. Input Fields
            Text("Email", modifier = Modifier.fillMaxWidth().padding(start = 12.dp), color = Color.DarkGray)
            TextField(
                value = user,
                onValueChange = { user = it },
                placeholder = { Text("johndoe@exemple.com", color = Color.Gray) },
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

            Text("Password", modifier = Modifier.fillMaxWidth().padding(start = 12.dp), color = Color.DarkGray)
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

            // 3. Login Button
            Button(
                onClick = { viewModel.login(user, pass) { navController.navigate("dashboard") } },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(55.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B5E20)) // Dark Green
            ) {
                Text("Log in", fontSize = 18.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(32.dp))

            // 4. Social Login Section
            Text("Log in with", color = Color.Gray, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Replace these with your actual icon drawables (google, facebook, github)
                SocialIcon(R.drawable.ic_google)
                SocialIcon(R.drawable.ic_facebook)
                SocialIcon(R.drawable.ic_github)
            }

            Spacer(modifier = Modifier.weight(1f))

            // 5. Footer (Sign up)
            Row {
                Text("No account? ", color = Color.Gray)
                Text(
                    "Sign up",
                    color = Color(0xFF1B5E20),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { /* Navigate to Sign Up */ }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun SocialIcon(iconRes: Int) {
    Image(
        painter = painterResource(id = iconRes),
        contentDescription = null,
        modifier = Modifier.size(32.dp)
    )
}