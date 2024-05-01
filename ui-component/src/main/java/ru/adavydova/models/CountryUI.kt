package ru.adavydova.models

import androidx.compose.runtime.Immutable

@Immutable
data class CountryUI (
    val id: Long,
    val name: String,
    val code: String?,
    val picture: String,
    val slug: String
)

@Immutable
data class CityUI(
    val id: Long,
    val name: String,
    val slug: String,
    val preview: String,
    val itemsCount: Int
)