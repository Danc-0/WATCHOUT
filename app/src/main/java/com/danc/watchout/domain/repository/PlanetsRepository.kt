package com.danc.watchout.domain.repository

import com.danc.watchout.domain.models.Planets

interface PlanetsRepository {

    suspend fun getAllPlanets(pageNumber: Int): Planets

}