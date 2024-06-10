package ru.adavydova.voyages_data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.adavydova.voyages_api.Resource
import ru.adavydova.voyages_api.models.traverse_api.DataResponse
import ru.adavydova.voyages_api.models.traverse_api.ItemTraverseDto
import ru.adavydova.voyages_data.mapper.toItemTraverse
import ru.adavydova.voyages_data.models.CityMetadata
import ru.adavydova.voyages_data.models.ItemTraverse

class ItemTraversePagingSource<T : ItemTraverseDto<T>, P: ItemTraverse<P>>(
    private val request: suspend (Int) -> Resource<DataResponse<T>>,
) : PagingSource<Int, P>() {

    override fun getRefreshKey(state: PagingState<Int, P>): Int? {
        return state.anchorPosition?.let {
            val anchorPosition = state.closestPageToPosition(it)
            anchorPosition?.nextKey?.minus(1) ?: anchorPosition?.prevKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, P> {
        val page = params.key ?: 1
        return when (val data = request(page)) {
            is Resource.Failure -> {
                LoadResult.Error(data.exception)
            }

            is Resource.Success -> {
                val itemTravers = data.result.response.results
                val itemTraverse: List<P> = data.result.response.results.map { (it.toItemTraverse()) as P}

                LoadResult.Page(
                    data = itemTraverse,
                    prevKey = if (page > 1) page.minus(1) else null,
                    nextKey = if (data.result.response.next != null) data.result.response.next else null
                )
            }
        }
    }
}
