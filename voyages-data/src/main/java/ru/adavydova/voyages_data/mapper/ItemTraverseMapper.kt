package ru.adavydova.voyages_data.mapper

import ru.adavydova.voyages_api.models.traverse_api.AuthorDto
import ru.adavydova.voyages_api.models.traverse_api.CountryDto
import ru.adavydova.voyages_api.models.traverse_api.ItemTraverseDto
import ru.adavydova.voyages_api.models.traverse_api.TagDto
import ru.adavydova.voyages_data.models.Author
import ru.adavydova.voyages_data.models.Country
import ru.adavydova.voyages_data.models.ItemTraverse
import ru.adavydova.voyages_data.models.Tag

fun ItemTraverseDto<*>.toItemTraverse(): ItemTraverse<*> {
    return when (this) {
        is ItemTraverseDto.AttractionDto -> toAttraction()
        is ItemTraverseDto.CityDto -> toCity()
        is ItemTraverseDto.ProductDto -> toProduct()
    }
}

fun ItemTraverseDto.CityDto.toCity(): ItemTraverse.City {
    return ItemTraverse.City(
        id = id,
        name = name,
        slug = slug,
        preview = preview,
        itemsCount = itemsCount,
    )
}

fun TagDto.toTag() = Tag(
    audioGuide = audioGuide,
    available = available
)

fun AuthorDto.toAuthor() = Author(
    avatar = avatar,
    name = name,
    bio = bio,
    nickname = nickname
)

fun CountryDto.toCountry() = Country(
    id = id,
    name = name,
    slug = slug
)

fun ItemTraverseDto.ProductDto.toProduct(): ItemTraverse.Product {
    return ItemTraverse.Product(
        id = id,
        title = title,
        slug = slug,
        preview = preview,
        price = price,
        cover = cover,
        exPrice = exPrice,
        currency = currency,
        currencyCode = currencyCode,
        raining = raining,
        reviewsCount = reviewsCount,
        ratingsCount = ratingsCount,
        category = category,
        city = cityDto.toCity(),
        duration = duration,
        durationMax = durationMax,
        durationMin = durationMin,
        tags = tags.toTag(),
        type = type,
        locale = locale,
        author = authorDto.toAuthor()
    )
}


fun ItemTraverseDto.AttractionDto.toAttraction(): ItemTraverse.Attraction {
    return ItemTraverse.Attraction(
        id = id,
        name = name,
        slug = slug,
        preview = preview,
        itemsCount = itemsCount
    )
}