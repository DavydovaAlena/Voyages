package ru.adavydova.voyages_api

import ru.adavydova.voyages_api.models.CountryDto
import ru.adavydova.voyages_api.models.DataResponse
import ru.adavydova.voyages_api.models.DataSearchResponse
import ru.adavydova.voyages_api.models.ItemTraverseDto
import ru.adavydova.voyages_api.models.ReviewDto

enum class OrderProduct {
    popularity, random
}

interface TraverseApi {

    suspend fun getCountries(page: Int): Resource<DataResponse<CountryDto>>

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

}