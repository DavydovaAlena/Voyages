package ru.adavydova.voyages_data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.adavydova.voyages_api.Resource
import ru.adavydova.voyages_api.VoyagesApi
import ru.adavydova.voyages_data.mapper.toCountry
import ru.adavydova.voyages_data.models.Country

class CountriesPagingSource(
    private val api: VoyagesApi
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
                val countries = data.result.response.results.map {
                    it.toCountry()
                }
                LoadResult.Page(
                    data = countries,
                    prevKey = if (page > 1) page.minus(1) else null,
                    nextKey = if (data.result.response.next != null) page.plus(1) else null
                )
            }
        }
    }
}