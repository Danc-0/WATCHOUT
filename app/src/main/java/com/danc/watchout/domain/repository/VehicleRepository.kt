package com.danc.watchout.domain.repository

import com.danc.watchout.domain.models.Vehicles

interface VehicleRepository {

   suspend fun getVehicle(pageNumber: Int): Vehicles

}