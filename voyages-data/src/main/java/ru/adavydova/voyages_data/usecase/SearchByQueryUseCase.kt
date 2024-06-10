package ru.adavydova.voyages_data.usecase

import ru.adavydova.voyages_api.Resource
import ru.adavydova.voyages_api.models.traverse_api.DataSearchResponse
import ru.adavydova.voyages_api.models.traverse_api.ItemTraverseDto
import ru.adavydova.voyages_data.repository.TraverseRepository

class SearchByQueryUseCase(
    private val traverseRepository: TraverseRepository
) {
    suspend operator fun invoke (query: String): Resource<DataSearchResponse<ItemTraverseDto<*>>> {
        return traverseRepository.searchByQuery(query)
    }
}