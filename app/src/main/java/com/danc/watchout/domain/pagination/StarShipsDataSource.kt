package com.danc.watchout.domain.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.danc.watchout.domain.models.StarShipsResult
import com.danc.watchout.domain.usecases.StarShipsUseCase
import javax.inject.Inject

class StarShipsDataSource @Inject constructor(
    private val startShipsUseCase: StarShipsUseCase
) : PagingSource<Int, StarShipsResult>() {

    override fun getRefreshKey(state: PagingState<Int, StarShipsResult>): Int? {
        val pager = state.anchorPosition?.let { anchorPosition ->
            val anchorPager = state.closestPageToPosition(anchorPosition)
            anchorPager?.prevKey?.plus(1) ?: anchorPager?.nextKey?.minus(1)
        }
        return pager
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, StarShipsResult> {
        return try {
            val nextPage = params.key ?: 1
            val response = startShipsUseCase(nextPage)
            LoadResult.Page(
                data = response.results,
                prevKey = if (response.previous != null) nextPage - 1 else null,
                nextKey = if (response.next != null) nextPage + 1 else null
            )
        } catch (e: Exception) {
            throw e
        }
    }
}