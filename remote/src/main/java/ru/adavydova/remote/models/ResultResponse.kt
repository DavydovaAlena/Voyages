package ru.adavydova.remote.models


data class ResultResponse<T>(
    val count:Int,
    val pages: Int,
    val current:Int,
    val next:Int?,
    val result: List<T>
)