package com.danc.watchout.data.remote.dto

import com.danc.watchout.domain.models.VehiclesResult

data class VehiclesResult(
    val cargo_capacity: String,
    val consumables: String,
    val cost_in_credits: String,
    val created: String,
    val crew: String,
    val edited: String,
    val films: List<String>,
    val length: String,
    val manufacturer: String,
    val max_atmosphering_speed: String,
    val model: String,
    val name: String,
    val passengers: String,
    val pilots: List<String>,
    val url: String,
    val vehicle_class: String
) {
    fun toVehicleResult(): VehiclesResult {
        return VehiclesResult(
            cargo_capacity,
            consumables,
            cost_in_credits,
            created, crew,
            films,
            length,
            manufacturer,
            max_atmosphering_speed,
            model,
            name,
            passengers,
            pilots,
            vehicle_class
        )
    }
}