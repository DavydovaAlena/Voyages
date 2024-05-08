package ru.adavydova.voyages_data.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.adavydova.voyages_data.models.ItemTraverse
import ru.adavydova.voyages_data.repository.TraverseRepository

class GetAttractionUseCase (
    private val traverseRepository: TraverseRepository
) {
    operator fun invoke (): Flow<PagingData<ItemTraverse.Attraction>> {
        return traverseRepository.getAttraction()
    }
}