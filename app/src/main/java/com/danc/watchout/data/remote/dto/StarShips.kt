package com.danc.watchout.data.remote.dto

data class StarShips(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<StarShipsResult>
)