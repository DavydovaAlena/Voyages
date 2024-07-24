package ru.adavydova.voyages_api.models.traverse_api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthorDto(
    @SerialName("avatar")
    val avatar: String,
    @SerialName("name")
    val name:String,
    @SerialName("bio")
    val bio: String,
    @SerialName("nickname")
    val nickname: String
)
