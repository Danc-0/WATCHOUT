package com.danc.watchout.domain.usecases

import com.danc.watchout.domain.models.Planets
import com.danc.watchout.domain.repository.PlanetsRepository
import javax.inject.Inject

class PlanetUseCase @Inject constructor(private val repository: PlanetsRepository) {

    suspend operator fun invoke(pageNumber: Int): Planets {
        return repository.getAllPlanets(pageNumber)
    }
}