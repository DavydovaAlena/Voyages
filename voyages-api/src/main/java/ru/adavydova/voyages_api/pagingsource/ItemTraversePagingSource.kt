package ru.adavydova.voyages_api.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.adavydova.voyages_api.Resource
import ru.adavydova.voyages_api.models.DataResponse
import ru.adavydova.voyages_api.models.ItemTraverse

class ItemTraversePagingSource<T: ItemTraverse<T>>(
    private val request: suspend (Int) -> Resource<DataResponse<T>>
) : PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let {
            val anchorPosition = state.closestPageToPosition(it)
            anchorPosition?.nextKey?.minus(1) ?: anchorPosition?.prevKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val page = params.key?:1
        return when(val data = request(page)){
            is Resource.Failure -> {
                LoadResult.Error(data.exception)
            }
            is Resource.Success -> {
                LoadResult.Page(
                    data = data.result.response.results,
                    prevKey = if (page>1) page.minus(1) else null,
                    nextKey = if (data.result.response.next != null) page.plus(1) else null
                )
            }
        }
    }
}
