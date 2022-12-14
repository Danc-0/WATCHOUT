package com.danc.watchout.domain.models

data class VehiclesResult(
    val cargo_capacity: String,
    val consumables: String,
    val cost_in_credits: String,
    val created: String,
    val crew: String,
    val films: List<String>,
    val length: String,
    val manufacturer: String,
    val max_atmosphering_speed: String,
    val model: String,
    val name: String,
    val passengers: String,
    val pilots: List<String>,
    val vehicle_class: String
)