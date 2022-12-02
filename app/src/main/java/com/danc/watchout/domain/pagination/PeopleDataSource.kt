package com.danc.watchout.domain.pagination

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.log
import com.danc.watchout.domain.models.Peoples
import com.danc.watchout.domain.models.PeoplesResult
import com.danc.watchout.domain.repository.PeopleRepository
import com.danc.watchout.domain.usecases.PeoplesUseCase
import com.danc.watchout.presentation.viewmodels.PeopleViewModel
import com.danc.watchout.utils.Resource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

class PeopleDataSource(
    private val peoplesUseCase: PeoplesUseCase
) : PagingSource<Int, PeoplesResult>() {

    override fun getRefreshKey(state: PagingState<Int, PeoplesResult>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PeoplesResult> {
        return try {
            val nextPageNumber = params.key ?: 1
            val size = params.loadSize
            val from = nextPageNumber * size
            val response = peoplesUseCase(nextPageNumber)
            val previousKey = if (response.previous?.isNotEmpty() == true && nextPageNumber <= 0) nextPageNumber - 1  else null
            val nextKey = if (response.next?.isNotEmpty() == true) nextPageNumber + 1 else null

            LoadResult.Page(
                data = response.results,
                prevKey =  previousKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}