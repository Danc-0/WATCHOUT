package com.danc.watchout.presentation.navigation

import com.danc.watchout.R

sealed class BottomNavRoutes(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
    ) {

    object Splash : BottomNavRoutes(
        route = "splash_screen",
        title = "Splash Screen",
        0,
        0
    )

    object Home : BottomNavRoutes(
        route = "home_screen",
        title = "People",
        icon = R.drawable.people,
        icon_focused = R.drawable.people
    )

    object Film : BottomNavRoutes(
        route = "film_screen",
        title = "Film",
        icon = R.drawable.films,
        icon_focused = R.drawable.films
    )

    object Vehicle : BottomNavRoutes(
        route = "vehicle_screen",
        title = "Vehicle",
        icon = R.drawable.vehicle,
        icon_focused = R.drawable.vehicle
    )

    object Planets : BottomNavRoutes(
        route = "planets_screen",
        title = "Planets",
        icon = R.drawable.planets,
        icon_focused = R.drawable.planets
    )

    object StarShip : BottomNavRoutes(
        route = "star_ship_screen",
        title = "Star Ship",
        icon = R.drawable.star_ship,
        icon_focused = R.drawable.star_ship
    )

}