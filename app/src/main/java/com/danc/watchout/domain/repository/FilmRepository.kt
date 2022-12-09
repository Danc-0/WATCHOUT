package com.danc.watchout.domain.repository

import com.danc.watchout.domain.models.Films

interface FilmRepository {

    suspend fun getAllFilms(): Films

}