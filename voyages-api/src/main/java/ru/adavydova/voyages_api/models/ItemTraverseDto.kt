package ru.adavydova.voyages_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
sealed class ItemTraverseDto<out T>{
    @Serializable
    data class AttractionDto(
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
    ): ItemTraverseDto<AttractionDto>()


    @Serializable
    data class CityDto (
        @SerialName("id")
        val id: Long,
        @SerialName("name")
        val name: String,
        @SerialName("slug")
        val slug: String,
        @SerialName("preview")
        val preview: String,
        @SerialName("itemsCount")
        val itemsCount: Int
    ): ItemTraverseDto<CityDto>()


    @Serializable
    data class ProductDto(

        @SerialName("id")
        val id: Long,
        @SerialName("title")
        val title: String,
        @SerialName("slug")
        val slug: String,
        @SerialName("cover")
        val cover:String,
        @SerialName("preview")
        val preview: String,
        @SerialName("price")
        val price: Int,
        @SerialName("exprice")
        val exPrice: Int,
        @SerialName("currency")
        val currency: String,
        @SerialName("currencyCode")
        val currencyCode: String,
        @SerialName("raining")
        val raining: Int?,
        @SerialName("reviewsCount")
        val reviewsCount: Int,
        @SerialName("ratingsCount")
        val ratingsCount: Int,
        @SerialName("category")
        val category: String,
        @SerialName("city")
        val cityDto: CityDto,
        @SerialName("duration")
        val duration: String,
        @SerialName("durationMin")
        val durationMin: Int,
        @SerialName("durationMax")
        val durationMax: Int,
        @SerialName("type")
        val type: Int,
        @SerialName("tags")
        val tags: TagDto,
        @SerialName("locale")
        val locale: String,
        @SerialName("author")
        val authorDto: AuthorDto
    ): ItemTraverseDto<ProductDto>()

}