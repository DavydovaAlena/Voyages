package ru.adavydova.recommendation_feature.mapper

import ru.adavydova.models.CityUI
import ru.adavydova.voyages_data.models.ItemTraverse

fun ItemTraverse.City.toCityUI(): CityUI {
    return CityUI(
        id = id,
        name = name,
        slug = slug,
        preview = preview,
        itemsCount = itemsCount,)
}