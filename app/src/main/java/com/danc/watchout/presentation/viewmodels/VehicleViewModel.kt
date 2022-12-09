package com.danc.watchout.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.danc.watchout.domain.pagination.VehicleDataSource
import com.danc.watchout.domain.usecases.VehicleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VehicleViewModel @Inject constructor(private val vehicleUseCase: VehicleUseCase): ViewModel() {

    val vehiclePager = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = {
            VehicleDataSource(vehicleUseCase)
        }
    ).flow.cachedIn(viewModelScope)

}