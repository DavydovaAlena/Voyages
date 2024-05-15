package ru.adavydova.recommendation_feature.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import ru.adavydova.ui_component.error_block.ErrorRequestBlock
import ru.adavydova.ui_component.error_block.NotFoundBlock
import ru.adavydova.ui_component.load_block.LoadRecommendationItemCard
import ru.adavydova.utils.shimmerLoadingAnimation

@Composable
fun <T : Any> LazyRowWithPagingData(
    modifier: Modifier = Modifier,
    items: LazyPagingItems<T>,
    item: @Composable (T) -> Unit
) {

    val state = remember(key1 = items.itemSnapshotList) { handlePaging(items) }

    LazyRow(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        when (state) {
            is PagingState.Error -> {
                item {
                    ErrorRequestBlock(
                        modifier = Modifier.fillMaxSize(),
                        error = state.message.error.localizedMessage
                            ?: "Request error please try again later"
                    )
                }
            }

            PagingState.Load -> {
                items(5) {
                    LoadRecommendationItemCard(
                        modifier = Modifier
                            .clip(RoundedCornerShape(22.dp))
                            .fillMaxHeight()
                            .width(266.dp)
                            .shimmerLoadingAnimation()
                    )
                }
            }

            PagingState.Success -> {
                when (items.itemCount == 0) {
                    true -> {
                        item {
                            NotFoundBlock(
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }

                    false -> {
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