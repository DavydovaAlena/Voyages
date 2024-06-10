package ru.adavydova.voyages_api.models.traverse_api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TagDto (
    @SerialName("audioguide")
    val audioGuide: Boolean,
    @SerialName("available")
    val available: Boolean
)