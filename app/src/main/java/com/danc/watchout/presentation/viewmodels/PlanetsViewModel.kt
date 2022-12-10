package com.danc.watchout.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.danc.watchout.domain.pagination.PlanetsDataSource
import com.danc.watchout.domain.usecases.PlanetUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlanetsViewModel @Inject constructor(
    private val planetUseCase: PlanetUseCase
): ViewModel() {

    val planetPager = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = {
            PlanetsDataSource(planetUseCase)
        }
    ).flow.cachedIn(viewModelScope)

}