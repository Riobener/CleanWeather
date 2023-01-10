package com.example.weatherapponcompose.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weatherapponcompose.presentation.components.MainScreen
import com.example.weatherapponcompose.presentation.components.SettingsScreen
import com.example.weatherapponcompose.presentation.ui.Screen

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: WeatherViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(route = Screen.Home.route) {
            MainScreen(viewModel)
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen()
        }
    }
}