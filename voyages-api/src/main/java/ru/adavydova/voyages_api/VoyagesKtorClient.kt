package ru.adavydova.voyages_api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import ru.adavydova.voyages_api.models.location_metadata_api.CitiesMetadataDto
import ru.adavydova.voyages_api.models.traverse_api.CountryDto
import ru.adavydova.voyages_api.models.traverse_api.DataResponse
import ru.adavydova.voyages_api.models.traverse_api.DataSearchResponse
import ru.adavydova.voyages_api.models.traverse_api.ItemTraverseDto
import ru.adavydova.voyages_api.models.traverse_api.ReviewDto


sealed class Resource<T> {
    data class Success<T>(val result: T) : Resource<T>()
    class Failure<T>(val exception: Exception) : Resource<T>()
}

class VoyagesKtorClient(
    private val httpClient: HttpClient
) : VoyagesApi {

    private val weGoTripBaseUrl = "https://app.wegotrip.com/api/v2/"
    private val theCompaniesBaseUrl = "https://api.thecompaniesapi.com/v1/"

    override suspend fun getCountries(page: Int): Resource<DataResponse<CountryDto>> {
        return try {
            val data =
                httpClient.get { url("${weGoTripBaseUrl}countries/?page=$page") }
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
            val data = httpClient.get("${weGoTripBaseUrl}cities/?page=$page")
            Resource.Success(
                result = data.body()
            )
        } catch (e: Exception) {
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
            val data = httpClient.get("${weGoTripBaseUrl}attractions/?page=$page")
            Resource.Success(
                result = data.body()
            )
        } catch (e: Exception) {
            Resource.Failure(e)
        }
    }

    override suspend fun getReviews(page: Int, idProduct: Int): Resource<DataResponse<ReviewDto>> {
        return try {
            val data = httpClient.get("${weGoTripBaseUrl}reviews/?page=$page")
            Resource.Success(
                result = data.body()
            )
        } catch (e: Exception) {
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
            val data = httpClient.get("${weGoTripBaseUrl}products/?page=$page")
            Resource.Success(
                result = data.body()
            )
        } catch (e: Exception) {
            Resource.Failure(e)
        }
    }

    override suspend fun searchByQuery(query: String): Resource<DataSearchResponse<ItemTraverseDto<*>>> {
        return try {
            val data = httpClient.get("${weGoTripBaseUrl}search/?query=$query")

            Resource.Success(
                DataSearchResponse(data.body())
            )
        } catch (e: Exception) {
            Resource.Failure(e)
        }
    }

    override suspend fun getMetadataOfTheCityByQuery(
        query: String,
        size: Int
    ): Resource<CitiesMetadataDto> {
        return try {
            val data =
                httpClient.get("${theCompaniesBaseUrl}locations/cities?search=$query&size=$size")
            Resource.Success(
                CitiesMetadataDto(data.body())
            )
        } catch (e: Exception) {
            Resource.Failure(e)
        }
    }
}

