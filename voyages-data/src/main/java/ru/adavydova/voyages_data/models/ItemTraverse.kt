package ru.adavydova.voyages_data.models


sealed class ItemTraverse<out T> {
    data class Attraction(
        val id: Long,
        val name: String,
        val slug: String,
        val preview: String,
        val itemsCount: Int
    ) : ItemTraverse<Attraction>()


    data class City(
        val id: Long,
        val name: String,
        val slug: String,
        val preview: String,
        val itemsCount: Int
    ) : ItemTraverse<City>()


    data class Product(
        val id: Long,
        val title: String,
        val slug: String,
        val cover: String,
        val preview: String,
        val price: Int,
        val exPrice: Int,
        val currency: String,
        val currencyCode: String,
        val raining: Int?,
        val reviewsCount: Int,
        val ratingsCount: Int,
        val category: String,
        val city: City,
        val duration: String,
        val durationMin: Int,
        val durationMax: Int,
        val type: Int,
        val tags: Tag,
        val locale: String,
        val author: Author
    ) : ItemTraverse<Product>()

}