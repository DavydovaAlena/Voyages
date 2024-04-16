package ru.adavydova.voyages_api

import ru.adavydova.voyages_api.models.Country
import ru.adavydova.voyages_api.models.DataResponse
import ru.adavydova.voyages_api.models.DataSearchResponse
import ru.adavydova.voyages_api.models.ItemTraverse
import ru.adavydova.voyages_api.models.Review

enum class OrderProduct {
    popularity, random
}

interface TraverseApi {

    suspend fun getCountries(page: Int): Resource<DataResponse<Country>>

    suspend fun getCities(
        page: Int,
        lang: String? = null,
        countryId: Long? = null,
        popular: Boolean = true
    ): Resource<DataResponse<ItemTraverse.City>>

    suspend fun getAttractions(
        page: Int,
        lang: String? = null,
        countryId: Long? = null,
        cityId: ItemTraverse.City? = null,
        popular: Boolean = true
    ): Resource<DataResponse<ItemTraverse.Attraction>>

    suspend fun getReviews(
        page: Int,
        idProduct: Int
    ): Resource<DataResponse<Review>>

    suspend fun getProducts(
        page: Int,
        lang: String? = null,
        currency: String? = null,
        countryId: Long? = null,
        cityId: Long? = null,
        attractionId: Long? = null,
        order: OrderProduct = OrderProduct.popularity
    ): Resource<DataResponse<ItemTraverse.Product>>

    suspend fun <T: ItemTraverse<T> > searchByQuery (query: String): Resource<DataSearchResponse<T>>

}