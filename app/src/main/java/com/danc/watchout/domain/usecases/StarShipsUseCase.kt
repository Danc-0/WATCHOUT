package com.danc.watchout.domain.usecases

import com.danc.watchout.domain.models.StarShips
import com.danc.watchout.domain.repository.StarShipsRepository
import javax.inject.Inject

class StarShipsUseCase @Inject constructor(private val repository: StarShipsRepository) {

    suspend operator  fun invoke(pageNumber: Int): StarShips {
        return repository.getAllStarShips(pageNumber)
    }

}