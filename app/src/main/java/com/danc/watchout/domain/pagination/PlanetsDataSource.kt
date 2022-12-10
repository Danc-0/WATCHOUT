package com.danc.watchout.domain.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.danc.watchout.domain.models.PlanetsResult
import com.danc.watchout.domain.usecases.PlanetUseCase

class PlanetsDataSource(
    private val planetUseCase: PlanetUseCase
) : PagingSource<Int, PlanetsResult>() {

    override fun getRefreshKey(state: PagingState<Int, PlanetsResult>): Int? {
        val page = state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
        return page
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PlanetsResult> {
        return try {
            val nextPage = params?.key ?: 1
            val response = planetUseCase(nextPage)
            LoadResult.Page(
                data = response.results,
                prevKey = if (response.previous != null) nextPage - 1 else null,
                nextKey = if (response.next != null) nextPage + 1 else null
            )
        } catch (exception: Exception) {
            throw exception
        }
    }


}