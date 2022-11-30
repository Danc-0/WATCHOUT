package com.danc.watchout.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.danc.watchout.presentation.screens.HomeScreen
import com.danc.watchout.presentation.screens.SplashScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.Splash.route
    ) {
        composable(route = ScreenRoutes.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = ScreenRoutes.Home.route) {
            HomeScreen()
        }
    }
}
