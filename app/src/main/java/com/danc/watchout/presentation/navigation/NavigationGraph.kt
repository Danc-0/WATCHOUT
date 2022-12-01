package com.danc.watchout.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.danc.watchout.presentation.screens.*

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
            HomeScreen(navController = navController)
        }

        composable(route = ScreenRoutes.Film.route) {
            FilmScreen(navController = navController)
        }

        composable(route = ScreenRoutes.Vehicle.route) {
            VehicleScreen(navController = navController)
        }

        composable(route = ScreenRoutes.StarShip.route) {
            StarShipScreen(navController = navController)
        }
    }
}
