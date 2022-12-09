package com.danc.watchout.domain.models

data class Vehicles(
    val count: Int,
    val next: String? = null,
    val previous: String? = null,
    val results: List<VehiclesResult>
)
