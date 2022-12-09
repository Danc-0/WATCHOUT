package com.danc.watchout.domain.usecases

import com.danc.watchout.domain.models.Vehicles
import com.danc.watchout.domain.repository.VehicleRepository
import javax.inject.Inject

class VehicleUseCase @Inject constructor(private val repository: VehicleRepository) {

    suspend operator fun invoke(pageNumber: Int): Vehicles {
        return repository.getVehicle(pageNumber)
    }

}