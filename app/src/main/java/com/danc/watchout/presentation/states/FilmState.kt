package com.danc.watchout.presentation.states

import com.danc.watchout.domain.models.SpecificFilmResult

data class FilmState(
    val specificFilm: List<SpecificFilmResult>? = null,
    val isLoading: Boolean = false
)