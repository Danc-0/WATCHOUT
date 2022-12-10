package com.danc.watchout.domain.repository

import com.danc.watchout.domain.models.StarShips

interface StarShipsRepository {

    suspend fun getAllStarShips(pageNumber: Int): StarShips

}