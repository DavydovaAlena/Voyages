package ru.adavydova.recommendation_feature.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RecommendationLineIndicator(
    modifier: Modifier = Modifier,
    selectedItem: Int = 1,
    items: RecommendationItemsList = RecommendationItemsList(RecommendationItems.items)
) {

    Box(
        modifier = modifier
            .fillMaxHeight()
            .padding(20.dp)
            .wrapContentWidth()
    ) {

        VerticalDivider(
            modifier = Modifier
                .height(24.dp)
                .graphicsLayer {
                    this.translationY = 100f
                },
            thickness = 2.dp
        )
    }
}

@Preview
@Composable
private fun RecommendationLineIndicatorPreview() {
    RecommendationLineIndicator(
//        recommendationItemsList = RecommendationItems.items
    )
}