package ru.adavydova.voyages_api.models.location_metadata_api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CityMetadataDto (
    @SerialName("code")
    val code: String,
    @SerialName("continent")
    val continent: ContinentMetadataDto,
    @SerialName("country")
    val country: CountryMetadataDto,
    @SerialName("county")
    val county: CountyMetadataDto



)