package com.danc.watchout.domain.models

import com.danc.watchout.domain.models.StarShipsResult

data class StarShips(
    val count: Int,
    val next: String? = null,
    val previous: String? = null,
    val results: List<StarShipsResult>
)