package com.danc.watchout.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.danc.watchout.domain.pagination.StarShipsDataSource
import com.danc.watchout.domain.usecases.StarShipsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StarShipsViewModel @Inject constructor(private val starShipsUseCase: StarShipsUseCase): ViewModel() {

    val starShipPager = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = {
            StarShipsDataSource(starShipsUseCase)
        }
    ).flow.cachedIn(viewModelScope)

}