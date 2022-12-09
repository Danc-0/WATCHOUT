package com.danc.watchout.domain.usecases

import com.danc.watchout.domain.models.Films
import com.danc.watchout.domain.repository.FilmRepository
import javax.inject.Inject

class FilmsUseCase @Inject constructor(private val filmRepository: FilmRepository) {

    suspend operator fun invoke(pageNumber: Int): Films {
        return filmRepository.getAllFilms(pageNumber)
    }

}