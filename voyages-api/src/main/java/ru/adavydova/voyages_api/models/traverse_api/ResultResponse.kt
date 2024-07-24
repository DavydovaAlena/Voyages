package ru.adavydova.voyages_api.models.traverse_api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataResponse<T>(
    @SerialName("data")
    val response: ResultResponse<T>
)

@Serializable
data class DataSearchResponse<out T>(
    @SerialName("data")
    val response: ResultSearchResponse<T>
)

@Serializable
data class ResultSearchResponse<out T>(
    @SerialName("results")
    val results: List<T>
)

@Serializable
data class ResultResponse<T>(
    @SerialName("count")
    val count:Int,
    @SerialName("pages")
    val pages: Int,
    @SerialName("current")
    val current:Int,
    @SerialName("next")
    val next:Int?,
    @SerialName("results")
    val results: List<T>
)