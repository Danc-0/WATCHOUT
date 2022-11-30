package com.danc.watchout.data.remote.dto

data class Planets(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<PlanetsResult>
)