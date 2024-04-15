package ru.adavydova.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Attraction(
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name:String,
    @SerialName("slug")
    val slug: String,
    @SerialName("preview")
    val preview:String,
    @SerialName("itemsCount")
    val itemsCount: Int
): ItemTraverse


enum class OrderProduct {
    popularity, random
}