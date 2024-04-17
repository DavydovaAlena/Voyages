package ru.adavydova.models

import androidx.compose.runtime.Immutable

@Immutable
data class CountryUI (
    val id: Long,
    val name: String,
    val code: String?,
    val slug: String
)