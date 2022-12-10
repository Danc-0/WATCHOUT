package com.danc.watchout.domain.models

data class Planets(
    val count: Int,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PlanetsResult>
)