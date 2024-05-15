package ru.adavydova.recommendation_feature.util

import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems

fun <T : Any> handlePaging(
    pagingItems: LazyPagingItems<T>
): PagingState {
    val loadState = pagingItems.loadState
    val load = when (loadState.refresh is LoadState.Loading
            || loadState.append is LoadState.Loading) {
        true -> true
        false -> false
    }
    val error: LoadState.Error? = when {
        loadState.refresh is LoadState.Error -> {
            (loadState.refresh as LoadState.Error)
        }
        loadState.append is LoadState.Error -> {
            (loadState.append as LoadState.Error)
        }
        else -> null
    }

    return when {
        error != null -> PagingState.Error(error)
        load -> PagingState.Load
        else -> PagingState.Success
    }

}


sealed class PagingState {
    data object Load : PagingState()
    class Error(val message: LoadState.Error) : PagingState()
    data object Success : PagingState()
}