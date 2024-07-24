package ru.adavydova.voyages_api.models.location_metadata_api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CountyMetadataDto (
    @SerialName("code")
    val code: String,
    @SerialName("latitude")
    val latitude: String,
    @SerialName("longitude")
    val longitude: String,
    @SerialName("name")
    val name: String
)