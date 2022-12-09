package com.danc.watchout.data.repository

import com.danc.watchout.data.remote.StarWarsAPI
import com.danc.watchout.domain.models.Vehicles
import com.danc.watchout.domain.repository.VehicleRepository
import javax.inject.Inject

class VehicleRepositoryImpl @Inject constructor(private val starWarsAPI: StarWarsAPI): VehicleRepository {

    override suspend fun getVehicle(pageNumber: Int): Vehicles {
        try {
            return starWarsAPI.getVehicles(pageNumber).toVehicles()
        } catch (e: Exception){
            throw e
        }
    }
}