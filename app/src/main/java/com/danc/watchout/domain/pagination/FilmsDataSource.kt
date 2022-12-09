package com.danc.watchout.domain.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.danc.watchout.domain.models.FilmsResult
import com.danc.watchout.domain.usecases.FilmsUseCase

class FilmsDataSource(
    private val filmsUseCase: FilmsUseCase
): PagingSource<Int, FilmsResult>() {

    override fun getRefreshKey(state: PagingState<Int, FilmsResult>): Int? {
        val page = state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
        return page
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FilmsResult> {
       return try {
            val nextPageNumber = params.key ?: 1
            val response = filmsUseCase()
            LoadResult.Page(
                data = response.results,
                prevKey = if (response.previous != null) nextPageNumber - 1 else null,
                nextKey = if (response.next != null) nextPageNumber + 1 else null
            )
        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}