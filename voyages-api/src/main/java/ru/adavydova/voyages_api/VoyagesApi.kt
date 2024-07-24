package ru.adavydova.voyages_api

import ru.adavydova.voyages_api.models.location_metadata_api.CitiesMetadataDto
import ru.adavydova.voyages_api.models.traverse_api.CountryDto
import ru.adavydova.voyages_api.models.traverse_api.DataResponse
import ru.adavydova.voyages_api.models.traverse_api.DataSearchResponse
import ru.adavydova.voyages_api.models.traverse_api.ItemTraverseDto
import ru.adavydova.voyages_api.models.traverse_api.ResultResponse
import ru.adavydova.voyages_api.models.traverse_api.ReviewDto

enum class OrderProduct {
    popularity, random
}

interface VoyagesApi {

    suspend fun getCountries(page: Int): Resource<DataResponse<CountryDto>>

    /*
        Returns basic information about the cities.
        Example query:https://app.wegotrip.com/api/v2/cities/
    */
    suspend fun getCities(
        page: Int,
        lang: String? = null,
        countryId: Long? = null,
        popular: Boolean = true
    ): Resource<DataResponse<ItemTraverseDto.CityDto>>

    suspend fun getAttractions(
        page: Int,
        lang: String? = null,
        countryId: Long? = null,
        cityDtoId: ItemTraverseDto.CityDto? = null,
        popular: Boolean = true
    ): Resource<DataResponse<ItemTraverseDto.AttractionDto>>

    suspend fun getReviews(
        page: Int,
        idProduct: Int
    ): Resource<DataResponse<ReviewDto>>

    suspend fun getProducts(
        page: Int,
        lang: String? = null,
        currency: String? = null,
        countryId: Long? = null,
        cityId: Long? = null,
        attractionId: Long? = null,
        order: OrderProduct = OrderProduct.popularity
    ): Resource<DataResponse<ItemTraverseDto.ProductDto>>


    suspend fun searchByQuery (query: String): Resource<DataSearchResponse<ItemTraverseDto<*>>>

   /*
        returns additional information about the city whose name
        was passed in the request as "query".
        "query" - field "name" of class CityDto

        Example query: https://api.thecompaniesapi.com/v1/locations/cities?search=lisbon&size=1
    */
    
    suspend fun getMetadataOfTheCityByQuery(
        query: String,
        size: Int = 1
        ): Resource<CitiesMetadataDto>


}