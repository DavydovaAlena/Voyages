package ru.adavydova.voyages_data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.adavydova.voyages_api.Resource
import ru.adavydova.voyages_api.TraverseApi
import ru.adavydova.voyages_api.models.DataSearchResponse
import ru.adavydova.voyages_api.models.ItemTraverseDto
import ru.adavydova.voyages_data.models.Country
import ru.adavydova.voyages_data.models.ItemTraverse
import ru.adavydova.voyages_data.pagingsource.CountriesPagingSource
import ru.adavydova.voyages_data.pagingsource.ItemTraversePagingSource

class TraverseRepository(
    private val traverseApi: TraverseApi
) {
    fun getCountries(): Flow<PagingData<Country>> {
        return Pager(
            pagingSourceFactory = { CountriesPagingSource(traverseApi) },
            config = PagingConfig(
                pageSize = 10
            )
        ).flow
    }

    fun getCities(): Flow<PagingData<ItemTraverse.City>> {
        return Pager(
            pagingSourceFactory = {
                ItemTraversePagingSource<ItemTraverseDto.CityDto, ItemTraverse.City>(request = {
                    traverseApi.getCities(page = it)
                })
            },
            config = PagingConfig(
                pageSize = 10
            )
        ).flow
    }

    fun getProducts(): Flow<PagingData<ItemTraverse.Product>> {
        return Pager(
            pagingSourceFactory = {
                ItemTraversePagingSource<ItemTraverseDto.ProductDto, ItemTraverse.Product>(request = {
                    traverseApi.getProducts(page = it)
                })
            },
            config = PagingConfig(
                pageSize = 10
            )
        ).flow
    }

    fun getAttraction(): Flow<PagingData<ItemTraverse.Attraction>> {
        return Pager(
            pagingSourceFactory = {
                ItemTraversePagingSource<ItemTraverseDto.AttractionDto, ItemTraverse.Attraction>(request = {
                    traverseApi.getAttractions(page = it)
                })
            },
            config = PagingConfig(
                pageSize = 10
            )
        ).flow
    }

    suspend fun searchByQuery(query: String): Resource<DataSearchResponse<ItemTraverseDto<*>>> {
        return traverseApi.searchByQuery(query)
    }
}
