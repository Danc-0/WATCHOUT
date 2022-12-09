package com.danc.watchout.domain.usecases

import com.danc.watchout.domain.models.SpecificFilmResult
import com.danc.watchout.domain.repository.PeopleRepository
import com.danc.watchout.utils.Resource
import kotlinx.coroutines.flow.Flow

class SpecificFilmUseCase(private val peopleRepository: PeopleRepository) {

    suspend operator fun invoke(url: String): Flow<Resource<SpecificFilmResult>> {
        return peopleRepository.getSpecificFilm(url)
    }

}