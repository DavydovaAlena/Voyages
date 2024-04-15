package ru.adavydova.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Review(
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
