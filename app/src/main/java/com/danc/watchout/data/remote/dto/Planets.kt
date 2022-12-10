package com.danc.watchout.data.remote.dto

import com.danc.watchout.domain.models.Planets

data class Planets(
    val count: Int,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PlanetsResult>
) {
    fun toPlanets(): Planets {
        return Planets(
            count = count,
            next = next,
            previous = previous,
            results = results.map { it.toPlanetsResult() }
        )
    }
}