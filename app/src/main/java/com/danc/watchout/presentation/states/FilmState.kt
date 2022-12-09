package com.danc.watchout.presentation.states

import com.danc.watchout.domain.models.SpecificFilmResult

data class FilmState(
    val specificFilm: ArrayList<SpecificFilmResult>? = null,
    val isLoading: Boolean = false
)