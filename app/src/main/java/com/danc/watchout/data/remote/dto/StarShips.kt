package com.danc.watchout.data.remote.dto

import com.danc.watchout.domain.models.StarShips

data class StarShips(
    val count: Int,
    val next: String,
    val previous: String? = null,
    val results: List<StarShipsResult>
) {
    fun toStarShips(): StarShips {
        return StarShips(
            count,
            next,
            previous,
            results.map { it.toStarShipResult() }
        )
    }
}