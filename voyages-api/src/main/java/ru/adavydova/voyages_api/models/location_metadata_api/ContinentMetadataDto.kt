package ru.adavydova.voyages_api.models.location_metadata_api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContinentMetadataDto (
    @SerialName("code")
    val code: String,
    @SerialName("latitude")
    val latitude: String,
    @SerialName("longitude")
    val longitude: String,
    @SerialName("name")
    val name: String,
    @SerialName("nameEs")
    val nameEs: String,
    @SerialName("nameFr")
    val nameFr: String
)