package ru.adavydova.voyages_api.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.adavydova.voyages_api.Resource
import ru.adavydova.voyages_api.TraverseApi
import ru.adavydova.voyages_api.models.Country

class CountriesPagingSource(
    private val api: TraverseApi
) : PagingSource<Int, Country>() {
    override fun getRefreshKey(state: PagingState<Int, Country>): Int? {
        return state.anchorPosition?.let {
            val anchorPosition = state.closestPageToPosition(it)
            anchorPosition?.nextKey?.minus(1) ?: anchorPosition?.prevKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Country> {
        val page = params.key ?: 1
        return when (val data = api.getCountries(page)) {
            is Resource.Failure -> {
                LoadResult.Error(
                    throwable = data.exception
                )
            }

            is Resource.Success -> {
                LoadResult.Page(
                    data = data.result.response.results,
                    prevKey = if (page > 1) page.minus(1) else null,
                    nextKey = if (data.result.response.next != null) page.plus(1) else null
                )
            }
        }
    }
}