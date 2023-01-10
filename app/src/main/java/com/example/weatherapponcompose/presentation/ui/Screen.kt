package com.example.weatherapponcompose.presentation.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home_screen", "Main", Icons.Default.Home )
    object Settings : Screen("settings_screen", "Settings", Icons.Default.Settings )
}