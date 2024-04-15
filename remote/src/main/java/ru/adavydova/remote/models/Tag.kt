package ru.adavydova.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tag (
    @SerialName("audioguide")
    val audioGuide: Boolean,
    @SerialName("available")
    val available: Boolean
)