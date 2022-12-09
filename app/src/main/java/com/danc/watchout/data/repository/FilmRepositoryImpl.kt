package com.danc.watchout.data.repository

import com.danc.watchout.data.remote.StarWarsAPI
import com.danc.watchout.domain.models.Films
import com.danc.watchout.domain.repository.FilmRepository
import retrofit2.HttpException

class FilmRepositoryImpl (private val starWarsAPI: StarWarsAPI): FilmRepository {

    override suspend fun getAllFilms(): Films {
        try {
            return starWarsAPI.getFilms().toFilms()
        } catch (exception: HttpException){
            throw exception
        }
    }
}