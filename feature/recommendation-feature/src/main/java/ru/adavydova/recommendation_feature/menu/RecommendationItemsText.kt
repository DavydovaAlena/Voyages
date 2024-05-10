package ru.adavydova.recommendation_feature.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.adavydova.recommendation_feature.util.vertical
import ru.adavydova.utils.ColorUI
import ru.adavydova.utils.FontUI

@Composable
fun RecommendationItemsText(
    modifier: Modifier,
    recommendationItemsList: RecommendationItemsList,
    changePosition: (Int) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {

        recommendationItemsList.forEachIndexed { index, recommendationItems ->
            RecommendationItemText(
                modifier = Modifier.clickable { changePosition(index) },
                title = recommendationItems.title
            )
        }
    }
}

@Composable
private fun RecommendationItemText(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .vertical()
            .graphicsLayer {
                this.rotationZ = -90f
            },
        maxLines = 1,
        text = title,
        color = ColorUI.primaryBottomMenuButtonColor,
        fontFamily = FontUI.MontserratBold.toFontFamily(),
        fontSize = 12.sp
    )

}

@Preview
@Composable
fun RecommendationItemPreview() {
    RecommendationItemText(title = "Destionations")
}
