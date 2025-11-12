package com.example.layoutcomposeexample.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.layoutcomposeexample.ui.weather.screen.WeatherScreen
import com.example.layoutcomposeexample.ui.weather.screen.SettingsScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home"){
            WeatherScreen(navController = navController)
        }
        composable("settings"){
            SettingsScreen(navController = navController)
        }
    }
}
