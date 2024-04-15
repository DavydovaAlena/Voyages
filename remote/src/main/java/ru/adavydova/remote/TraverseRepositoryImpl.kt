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




class TraverseRepositoryImpl: TraverseRepository {
    override fun getCountries(page: Int): Flow<PagingData<ResultResponse<Country>>> {
        TODO("Not yet implemented")
    }

    override fun getCities(
        page: Int,
        lang: String?,
        countryId: Long?,
        popular: Boolean
    ): Flow<PagingData<ResultResponse<Country>>> {
        TODO("Not yet implemented")
    }

    override fun getAttractions(
        page: Int,
        lang: String?,
        countryId: Long?,
        cityId: City?,
        popular: Boolean
    ): Flow<PagingData<ResultResponse<Attraction>>> {
        TODO("Not yet implemented")
    }

    override fun getReviews(page: Int, idProduct: Int): Flow<PagingData<ResultResponse<Review>>> {
        TODO("Not yet implemented")
    }

    override fun getProducts(
        page: Int,
        lang: String?,
        currency: String?,
        countryId: Long?,
        cityId: Long?,
        attractionId: Long?,
        order: OrderProduct
    ): Flow<PagingData<ResultResponse<Product>>> {
        TODO("Not yet implemented")
    }

    override suspend fun searchByQuery(query: String): Result<ResultQuery> {
        TODO("Not yet implemented")
    }
}