package com.danc.watchout.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.danc.watchout.presentation.screens.*

@Composable
fun StartNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavRoutes.Splash.route
    ) {
        composable(route = BottomNavRoutes.Splash.route) {
            SplashScreen(navController = navController)
        }
    }
}
