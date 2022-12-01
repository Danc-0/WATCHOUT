package com.danc.watchout.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.danc.watchout.presentation.screens.*

@Composable
fun MainNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.Home.route
    ) {
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
