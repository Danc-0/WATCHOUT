package com.danc.watchout.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.danc.watchout.domain.pagination.FilmsDataSource
import com.danc.watchout.domain.usecases.FilmsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val filmsUseCase: FilmsUseCase
) : ViewModel() {

    val filmPager = Pager(
        config = PagingConfig(pageSize = 20)) {
            FilmsDataSource(filmsUseCase)
        }.flow.cachedIn(viewModelScope)

}