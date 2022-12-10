package com.danc.watchout.domain.models

data class PlanetsResult(
    val climate: String,
    val diameter: String,
    val films: List<String>,
    val gravity: String,
    val name: String,
    val orbital_period: String,
    val population: String,
    val residents: List<String>,
    val rotation_period: String,
    val surface_water: String,
    val terrain: String,
)
