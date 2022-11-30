package com.danc.watchout.utils

sealed class ScreenRoutes(val route: String) {
    object Splash : ScreenRoutes("splash_screen")
    object Home : ScreenRoutes("home_screen")
}