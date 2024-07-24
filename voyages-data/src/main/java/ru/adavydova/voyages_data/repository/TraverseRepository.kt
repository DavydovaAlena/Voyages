package ru.adavydova.voyages_data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.adavydova.voyages_api.Resource
import ru.adavydova.voyages_api.VoyagesApi
import ru.adavydova.voyages_api.models.traverse_api.DataSearchResponse
import ru.adavydova.voyages_api.models.traverse_api.ItemTraverseDto
import ru.adavydova.voyages_data.mapper.toCityMetadata
import ru.adavydova.voyages_data.models.CityMetadata
import ru.adavydova.voyages_data.models.Country
import ru.adavydova.voyages_data.models.ItemTraverse
import ru.adavydova.voyages_data.pagingsource.CountriesPagingSource
import ru.adavydova.voyages_data.pagingsource.ItemTraversePagingSource

class TraverseRepository(
    private val voyagesApi: VoyagesApi
) {
    fun getCountries(): Flow<PagingData<Country>> {
        return Pager(
            pagingSourceFactory = { CountriesPagingSource(voyagesApi) },
            config = PagingConfig(
                pageSize = 10
            )
        ).flow
    }

    fun getCities(): Flow<PagingData<ItemTraverse.City>> {
        return Pager(
            pagingSourceFactory = {
                ItemTraversePagingSource<ItemTraverseDto.CityDto, ItemTraverse.City>(
                    request = { voyagesApi.getCities(page = it)})
            },
            config = PagingConfig(
                pageSize = 10
            )
        ).flow
    }

    fun getProducts(): Flow<PagingData<ItemTraverse.Product>> {

        return Pager(
            pagingSourceFactory = {
                ItemTraversePagingSource<ItemTraverseDto.ProductDto, ItemTraverse.Product>(
                    request = { voyagesApi.getProducts(page = it)})
            },
            config = PagingConfig(
                pageSize = 10
            )
        ).flow
    }

    fun getAttraction(): Flow<PagingData<ItemTraverse.Attraction>> {
        return Pager(
            pagingSourceFactory = {
                ItemTraversePagingSource<ItemTraverseDto.AttractionDto, ItemTraverse.Attraction>(
                    request = { voyagesApi.getAttractions(page = it) })
            },
            config = PagingConfig(
                pageSize = 10
            )
        ).flow
    }

    suspend fun searchByQuery(query: String): Resource<DataSearchResponse<ItemTraverseDto<*>>> {
        return voyagesApi.searchByQuery(query)
    }

    suspend fun getMetadataOfTheCityByQuery(query: String): Resource<CityMetadata?> {
        return when (val result = voyagesApi.getMetadataOfTheCityByQuery(query)) {
            is Resource.Failure -> {
                Resource.Failure(result.exception)
            }
            is Resource.Success -> {
                val cityMetadata = result.result.cities.firstOrNull()?.toCityMetadata()
                Resource.Success(cityMetadata)
            }
        }
    }
}
