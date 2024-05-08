package ru.adavydova.recommendation_feature.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import ru.adavydova.ui_component.error_block.ErrorRequestBlock
import ru.adavydova.ui_component.error_block.NotFoundBlock
import ru.adavydova.ui_component.load_block.LoadRecommendationLazyRow

@Composable
fun <T : Any> LazyRowWithPagingData(
    modifier: Modifier = Modifier,
    items: LazyPagingItems<T>,
    item: @Composable (T) -> Unit
) {

    Box(modifier = modifier.fillMaxSize()) {
        when (val state = handlePaging(items)) {
            is PagingState.Error -> {
                ErrorRequestBlock(
                    modifier = Modifier.fillMaxSize(),
                    error = state.message.error.localizedMessage
                        ?: "Request error please try again later"
                )
            }

            PagingState.Load -> {
                LoadRecommendationLazyRow(
                    modifier = Modifier.fillMaxSize())
            }

            PagingState.Success -> {

                when (items.itemCount == 0) {
                    true -> {
                        NotFoundBlock(
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    false -> {
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(items.itemCount) {
                                items[it]?.let { type ->
                                    item(type)
                                }
                            }
                        }
                    }
                }

            }
        }

    }

}