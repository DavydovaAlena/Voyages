package ru.adavydova.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Author(
    @SerialName("avatar")
    val avatar: String,
    @SerialName("name")
    val name:String,
    @SerialName("bio")
    val bio: String,
    @SerialName("nickname")
    val nickname: String
)
