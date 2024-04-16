package ru.adavydova.voyages_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tag (
    @SerialName("audioguide")
    val audioGuide: Boolean,
    @SerialName("available")
    val available: Boolean
)