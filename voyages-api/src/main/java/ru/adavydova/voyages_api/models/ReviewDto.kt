package ru.adavydova.voyages_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewDto(
    @SerialName("name")
    val name: String,
    @SerialName("text")
    val text:String,
    @SerialName("avatar")
    val avatar:String,
    @SerialName("rating")
    val rating:Int,
    @SerialName("date")
    val date: String)
