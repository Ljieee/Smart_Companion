package com.example.smartcompanion.ui.theme.ViewModel


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BusinessCenter
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Settings
import androidx.lifecycle.ViewModel
import com.example.smartcompanion.Data.Department

class CampusViewModel : ViewModel() {

    // Functional Requirement #4: Static List of Departments
    // This list provides the data for your LazyColumn in the UI
    val departments = listOf(
        Department(
            name = "College of Computing Studies",
            contact = "ccs_dean@univ.edu.ph",
            icon = Icons.Default.Computer
        ),
        Department(
            name = "College of Engineering",
            contact = "coe_office@univ.edu.ph",
            icon = Icons.Default.Settings
        ),
        Department(
            name = "College of Business Administration",
            contact = "cba_inquiry@univ.edu.ph",
            icon = Icons.Default.BusinessCenter
        ),
        Department(
            name = "College of Arts and Sciences",
            contact = "cas_helpdesk@univ.edu.ph",
            icon = Icons.Default.Palette
        )
    )
}