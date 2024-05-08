package ru.adavydova.voyages_data.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.adavydova.voyages_data.models.Country
import ru.adavydova.voyages_data.repository.TraverseRepository

class GetCountriesUseCase (
    private val traverseRepository: TraverseRepository) {
    operator fun invoke (): Flow<PagingData<Country>> {
        return traverseRepository.getCountries()
    }
}