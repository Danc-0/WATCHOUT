package com.danc.watchout.presentation.navigation

import com.danc.watchout.R

sealed class ScreenRoutes(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
    ) {
    object Splash : ScreenRoutes(
        route = "splash_screen",
        title = "Splash Screen",
        0,
        0
    )

    object Home : ScreenRoutes(
        route = "home_screen",
        title = "People",
        icon = R.drawable.people,
        icon_focused = R.drawable.people
    )

    object Film : ScreenRoutes(
        route = "film_screen",
        title = "Film",
        icon = R.drawable.films,
        icon_focused = R.drawable.films
    )

    object Vehicle : ScreenRoutes(
        route = "vehicle_screen",
        title = "Vehicle",
        icon = R.drawable.vehicle,
        icon_focused = R.drawable.vehicle
    )

    object StarShip : ScreenRoutes(
        route = "star_ship_screen",
        title = "Star Ship",
        icon = R.drawable.star_ship,
        icon_focused = R.drawable.star_ship
    )

}