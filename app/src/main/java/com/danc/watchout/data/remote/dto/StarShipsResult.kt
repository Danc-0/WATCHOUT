package com.danc.watchout.data.remote.dto

import com.danc.watchout.domain.models.StarShipsResult

data class StarShipsResult(
    val MGLT: String,
    val cargo_capacity: String,
    val consumables: String,
    val cost_in_credits: String,
    val created: String,
    val crew: String,
    val edited: String,
    val films: List<String>,
    val hyperdrive_rating: String,
    val length: String,
    val manufacturer: String,
    val max_atmosphering_speed: String,
    val model: String,
    val name: String,
    val passengers: String,
    val pilots: List<String>,
    val starship_class: String,
    val url: String
) {
    fun toStarShipResult(): StarShipsResult {
        return StarShipsResult(
            MGLT,
            cargo_capacity,
            consumables,
            cost_in_credits,
            crew,
            films,
            hyperdrive_rating,
            length,
            manufacturer,
            max_atmosphering_speed,
            model,
            name,
            passengers,
            pilots,
            starship_class
        )
    }
}