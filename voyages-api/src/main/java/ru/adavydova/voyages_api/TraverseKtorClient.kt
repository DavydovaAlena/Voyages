package ru.adavydova.voyages_api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import ru.adavydova.voyages_api.models.CountryDto
import ru.adavydova.voyages_api.models.DataResponse
import ru.adavydova.voyages_api.models.DataSearchResponse
import ru.adavydova.voyages_api.models.ItemTraverseDto
import ru.adavydova.voyages_api.models.ReviewDto


sealed class Resource<T> {
    data class Success<T>(val result: T) : Resource<T>()
    class Failure<T>(val exception: Exception) : Resource<T>()
}

class TraverseKtorClient(
    private val httpClient: HttpClient
) : TraverseApi {

    override suspend fun getCountries(page: Int): Resource<DataResponse<CountryDto>> {
        return try {
            val data =
                httpClient.get { url("countries/?page=$page") }
            Resource.Success(
                result = data.body()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }

    }

    override suspend fun getCities(
        page: Int,
        lang: String?,
        countryId: Long?,
        popular: Boolean
    ): Resource<DataResponse<ItemTraverseDto.CityDto>> {
        return try {
          val data = httpClient.get("cities/?page=$page")
          Resource.Success(
              result = data.body()
          )
        } catch (e:Exception){
            Resource.Failure(e)
        }
    }

    override suspend fun getAttractions(
        page: Int,
        lang: String?,
        countryId: Long?,
        cityDtoId: ItemTraverseDto.CityDto?,
        popular: Boolean
    ): Resource<DataResponse<ItemTraverseDto.AttractionDto>> {
        return try {
            val data = httpClient.get("attractions/?page=$page")
            Resource.Success(
                result = data.body()
            )
        }catch (e:Exception){
            Resource.Failure(e)
        }
    }

    override suspend fun getReviews(page: Int, idProduct: Int): Resource<DataResponse<ReviewDto>> {
        return try {
            val data = httpClient.get("reviews/?page=$page")
            Resource.Success(
                result = data.body()
            )
        }catch (e:Exception){
            Resource.Failure(e)
        }
    }

    override suspend fun getProducts(
        page: Int,
        lang: String?,
        currency: String?,
        countryId: Long?,
        cityId: Long?,
        attractionId: Long?,
        order: OrderProduct
    ): Resource<DataResponse<ItemTraverseDto.ProductDto>> {
        return try {
            val data = httpClient.get("products/?page=$page")
            Resource.Success(
                result = data.body()
            )
        }catch (e:Exception){
            Resource.Failure(e)
        }
    }

    override suspend fun searchByQuery(query: String): Resource<DataSearchResponse<ItemTraverseDto<*>>> {
        return try {
            val data = httpClient.get("search/?query=$query")

            Resource.Success(
                DataSearchResponse(data.body())
            )
        }catch (e:Exception){
            Resource.Failure(e)
        }
    }

}

