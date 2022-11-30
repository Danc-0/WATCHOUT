package com.danc.watchout.data.remote.dto

data class Vehicles(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<VehiclesResult>
)