package ru.adavydova.recommendation_feature.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.adavydova.recommendation_feature.util.vertical
import ru.adavydova.utils.ColorUI
import ru.adavydova.utils.FontUI

@Composable
fun RecommendationItemsText(
    modifier: Modifier,
    selectedPosition: Int,
    recommendationItemsList: RecommendationItemsList,
    changePosition: (Int) -> Unit
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {

        recommendationItemsList.forEachIndexed { index, recommendationItems ->

            val tint = remember(selectedPosition) {
                when (selectedPosition == index) {
                    true -> ColorUI.primaryBottomMenuButtonColor
                    false -> ColorUI.unselectedButtonColor
                }
            }

            RecommendationItemText(
                modifier = Modifier.clickable { changePosition(index) },
                title = recommendationItems.title,
                tint = tint
            )
        }
    }
}

@Composable
private fun RecommendationItemText(
    title: String,
    tint: Color,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .vertical()
            .graphicsLayer { this.rotationZ = -90f },
        maxLines = 1,
        text = title,
        color = tint,
        fontFamily = FontUI.MontserratBold.toFontFamily(),
        fontSize = 12.sp
    )

}

