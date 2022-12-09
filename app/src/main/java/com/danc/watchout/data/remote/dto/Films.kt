package com.danc.watchout.data.remote.dto

import com.danc.watchout.domain.models.Films

data class Films(
    val count: Int,
    val next: String? = null,
    val previous: String? = null,
    val results: List<FilmsResult>
) {
    fun toFilms(): Films {
        return Films(
            count = count,
            next = next,
            previous = previous,
            results = results.map {
                it.toFilmsResult()
            }
        )
    }
}