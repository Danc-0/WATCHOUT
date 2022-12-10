package com.danc.watchout.data.remote.dto

import com.danc.watchout.domain.models.PlanetsResult

data class PlanetsResult(
    val climate: String,
    val created: String,
    val diameter: String,
    val edited: String,
    val films: List<String>,
    val gravity: String,
    val name: String,
    val orbital_period: String,
    val population: String,
    val residents: List<String>,
    val rotation_period: String,
    val surface_water: String,
    val terrain: String,
    val url: String
) {
    fun toPlanetsResult(): PlanetsResult {
        return PlanetsResult(
            climate,
            diameter,
            films,
            gravity,
            name,
            orbital_period,
            population,
            residents,
            rotation_period,
            surface_water,
            terrain
        )
    }
}