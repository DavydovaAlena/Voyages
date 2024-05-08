package ru.adavydova.recommendation_feature.mapper

import ru.adavydova.models.CountryUI
import ru.adavydova.voyages_data.models.Country

fun Country.toCountryUI() = CountryUI(
    id = id,
    name = name,
    code = getCountryCode(),
    picture = getCountryImage(),
    slug = slug
)
