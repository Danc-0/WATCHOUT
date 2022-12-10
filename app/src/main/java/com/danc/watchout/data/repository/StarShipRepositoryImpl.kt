package com.danc.watchout.data.repository

import com.danc.watchout.data.remote.StarWarsAPI
import com.danc.watchout.domain.models.StarShips
import com.danc.watchout.domain.repository.StarShipsRepository

class StarShipRepositoryImpl(private val starWarsAPI: StarWarsAPI): StarShipsRepository {

    override suspend fun getAllStarShips(pageNumber: Int): StarShips {
        try {
            return starWarsAPI.getStarships(pageNumber).toStarShips()
        } catch (e: Exception){
            throw e
        }
    }
}