package ru.adavydova.voyages_data.usecase

import ru.adavydova.voyages_api.Resource
import ru.adavydova.voyages_data.models.CityMetadata
import ru.adavydova.voyages_data.repository.TraverseRepository

class GetMetadataOfTheCityByQueryUseCase (
    private val traverseRepository: TraverseRepository
) {
    suspend operator fun invoke(query: String): Resource<CityMetadata?> {
        return traverseRepository.getMetadataOfTheCityByQuery(query)
    }
}