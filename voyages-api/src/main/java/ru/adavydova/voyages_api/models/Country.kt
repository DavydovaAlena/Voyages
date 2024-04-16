package ru.adavydova.voyages_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String
)