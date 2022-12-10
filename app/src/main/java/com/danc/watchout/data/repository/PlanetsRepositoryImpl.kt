package com.danc.watchout.data.repository

import com.danc.watchout.data.remote.StarWarsAPI
import com.danc.watchout.domain.models.Planets
import com.danc.watchout.domain.repository.PlanetsRepository
import javax.inject.Inject

class PlanetsRepositoryImpl @Inject constructor(private val starWarsAPI: StarWarsAPI): PlanetsRepository {

    override suspend fun getAllPlanets(pageNumber: Int): Planets {
        try {
            return starWarsAPI.getPlanets(pageNumber).toPlanets()
        } catch (exception: Exception){
            throw exception
        }
    }
}