package ru.adavydova.remote

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.adavydova.remote.models.Attraction
import ru.adavydova.remote.models.City
import ru.adavydova.remote.models.Country
import ru.adavydova.remote.models.OrderProduct
import ru.adavydova.remote.models.Product
import ru.adavydova.remote.models.ResultQuery
import ru.adavydova.remote.models.ResultResponse
import ru.adavydova.remote.models.Review
import java.util.Currency


interface TraverseRepository {

    fun getCountries(page: Int): Flow<PagingData<ResultResponse<Country>>>

    fun getCities(
        page: Int,
        lang: String? = null,
        countryId: Long? = null,
        popular: Boolean = true
    ): Flow<PagingData<ResultResponse<Country>>>

    fun getAttractions(
        page: Int,
        lang: String? = null,
        countryId: Long? = null,
        cityId: City? = null,
        popular: Boolean = true
    ): Flow<PagingData<ResultResponse<Attraction>>>

    fun getReviews(
        page: Int,
        idProduct: Int
    ): Flow<PagingData<ResultResponse<Review>>>

    fun getProducts(
        page: Int,
        lang: String? = null,
        currency:String? = null,
        countryId: Long? = null,
        cityId: Long? = null,
        attractionId: Long? = null,
        order: OrderProduct = OrderProduct.popularity
    ): Flow<PagingData<ResultResponse<Product>>>

    suspend fun searchByQuery(query: String): Result<ResultQuery>

}