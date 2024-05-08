package ru.adavydova.voyages_data.usecase

import android.app.DownloadManager.Query
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.adavydova.voyages_api.Resource
import ru.adavydova.voyages_api.models.DataSearchResponse
import ru.adavydova.voyages_api.models.ItemTraverseDto
import ru.adavydova.voyages_data.models.Country
import ru.adavydova.voyages_data.repository.TraverseRepository

class SearchByQueryUseCase(
    private val traverseRepository: TraverseRepository
) {
    suspend operator fun invoke (query: String): Resource<DataSearchResponse<ItemTraverseDto<*>>> {
        return traverseRepository.searchByQuery(query)
    }
}