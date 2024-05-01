package ru.adavydova.voyages_api.models


data class Review(
    val name: String,
    val text: String,
    val avatar: String,
    val rating: Int,
    val date: String
)
