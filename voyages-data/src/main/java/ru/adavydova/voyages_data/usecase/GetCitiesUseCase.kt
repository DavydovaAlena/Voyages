package ru.adavydova.voyages_data.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.adavydova.voyages_data.models.ItemTraverse
import ru.adavydova.voyages_data.repository.TraverseRepository

class GetCitiesUseCase(
    private val traverseRepository: TraverseRepository
) {
    operator fun invoke(): Flow<PagingData<ItemTraverse.City>> {
        return traverseRepository.getCities()
    }
}
