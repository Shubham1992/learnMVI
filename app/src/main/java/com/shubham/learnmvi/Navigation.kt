package com.shubham.learnmvi

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.MainScreen.route
    ) {
        composable(
            route = AppScreens.MainScreen.route
        ) {
            MainScreen()
        }
    }
}