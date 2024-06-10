package ru.adavydova.voyages_api.models.location_metadata_api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CitiesMetadataDto (
    @SerialName("cities")
    val cities: List<CityMetadataDto>
)
