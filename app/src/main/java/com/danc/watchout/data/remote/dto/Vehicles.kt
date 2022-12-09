package com.danc.watchout.data.remote.dto

import com.danc.watchout.domain.models.Vehicles

data class Vehicles(
    val count: Int,
    val next: String? = null,
    val previous: String? = null,
    val results: List<VehiclesResult>
) {
    fun toVehicles(): Vehicles {
        return Vehicles(
            count = count,
            next = next,
            previous = previous,
            results =  results.map { it.toVehicleResult() }
        )
    }
}