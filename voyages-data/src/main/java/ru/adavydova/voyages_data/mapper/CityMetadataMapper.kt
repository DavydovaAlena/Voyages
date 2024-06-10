package ru.adavydova.voyages_data.mapper

import ru.adavydova.voyages_api.models.location_metadata_api.CityMetadataDto
import ru.adavydova.voyages_data.models.CityMetadata


fun CityMetadataDto.toCityMetadata(): CityMetadata {
    return CityMetadata(
        name = county.name,
        longitude = county.longitude,
        latitude = country.latitude,
        codeCountry = county.code,
        nameCountry = country.name
    )
}