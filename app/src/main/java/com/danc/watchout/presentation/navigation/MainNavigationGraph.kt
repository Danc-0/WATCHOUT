package com.danc.watchout.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.danc.watchout.presentation.screens.*
import com.danc.watchout.presentation.viewmodels.PeopleViewModel

@Composable
fun MainNavigationGraph(
    navController: NavHostController,
    peopleViewModel: PeopleViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavRoutes.Home.route
    ) {
        composable(route = BottomNavRoutes.Home.route) {
            HomeScreen(navController = navController, viewModel = peopleViewModel)
        }

        composable(route = BottomNavRoutes.Film.route) {
            FilmScreen(navController = navController)
        }

        composable(route = BottomNavRoutes.Vehicle.route) {
            VehicleScreen(navController = navController)
        }

        composable(route = BottomNavRoutes.StarShip.route) {
            StarShipScreen(navController = navController)
        }

        composable(route = MainAppRoutes.PeopleDetails.route) {
            PeopleStarDetails(peopleViewModel)
        }
    }
}
