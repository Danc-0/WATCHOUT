package com.danc.watchout.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.danc.watchout.domain.models.PeoplesResult
import com.danc.watchout.domain.pagination.PeopleDataSource
import com.danc.watchout.domain.usecases.PeoplesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val peoplesUseCase: PeoplesUseCase
) : ViewModel() {

    val peoples: Flow<PagingData<PeoplesResult>> = Pager(
        pagingSourceFactory = {
            PeopleDataSource(peoplesUseCase)
        },
        config = PagingConfig(pageSize = 20)
    ).flow.cachedIn(viewModelScope)

}