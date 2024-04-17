package ru.adavydova.voyages_api

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.adavydova.voyages_api.models.Country
import ru.adavydova.voyages_api.models.DataSearchResponse
import ru.adavydova.voyages_api.models.ItemTraverse
import ru.adavydova.voyages_api.pagingsource.CountriesPagingSource
import ru.adavydova.voyages_api.pagingsource.ItemTraversePagingSource

class TraverseRepository(
    private val traverseApi: TraverseApi
) {
    fun getCountries(): Flow<PagingData<Country>> {
        return Pager(
            pagingSourceFactory = { CountriesPagingSource(traverseApi) },
            config = PagingConfig(
                pageSize = 20
            )
        ).flow
    }

    fun getCities(): Flow<PagingData<ItemTraverse.City>> {
        return Pager(
            pagingSourceFactory = {
                ItemTraversePagingSource(request = {
                    traverseApi.getCities(page = it)
                })
            },
            config = PagingConfig(
                pageSize = 20
            )
        ).flow
    }

    fun getProducts(): Flow<PagingData<ItemTraverse.Product>> {
        return Pager(
            pagingSourceFactory = {
                ItemTraversePagingSource(request = {
                    traverseApi.getProducts(page = it)
                })
            },
            config = PagingConfig(
                pageSize = 20
            )
        ).flow
    }

    fun getAttraction(): Flow<PagingData<ItemTraverse.Attraction>> {
        return Pager(
            pagingSourceFactory = {
                ItemTraversePagingSource(request = {
                    traverseApi.getAttractions(page = it)
                })
            },
            config = PagingConfig(
                pageSize = 20
            )
        ).flow
    }

    suspend fun searchByQuery (query: String): Resource<DataSearchResponse<ItemTraverse<*>>>{
        return traverseApi.searchByQuery(query)
    }
}

