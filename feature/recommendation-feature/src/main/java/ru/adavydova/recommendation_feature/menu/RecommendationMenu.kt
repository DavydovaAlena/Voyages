package ru.adavydova.recommendation_feature.menu

import androidx.compose.animation.core.AnimationState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateTo
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.adavydova.recommendation_feature.util.getStartPositionOffset
import ru.adavydova.utils.ColorUI


@Composable
fun RecommendationMenu(
    selectedPosition: Int,
    changePositionMenu: (Int)->Unit,
    modifier: Modifier = Modifier,
    recommendationItemsList: RecommendationItemsList
) {

    val sharedLength = remember {
        recommendationItemsList.sumOf { it.title.length }
    }
    val currentIndexLength = remember(selectedPosition) {
        mutableIntStateOf(recommendationItemsList[selectedPosition].title.length)
    }

    Row(
        modifier = modifier
            .height(260.dp)
            .width(100.dp)
    ) {
        var heights by rememberSaveable { mutableFloatStateOf(688.dp.value) }

        RecommendationItemsText(
            modifier = Modifier
                .onGloballyPositioned {
                    heights = it.size.height.toFloat()
                },
            recommendationItemsList = recommendationItemsList,
            selectedPosition = selectedPosition
        ) {
            changePositionMenu(it)
        }


        val itemsWeight = remember(heights) {
            hashMapOf<Int, Float>().let {
                recommendationItemsList.forEachIndexed { index, recommendationItems ->
                    val weight = heights * recommendationItems.title.length / sharedLength
                    it[index] = weight
                }
                it
            }
        }

        val animated = remember {
            AnimationState(
                initialValue = itemsWeight.getStartPositionOffset(
                    currentPosition = selectedPosition,
                    margin = 30.dp.value
                ).startPosition,
            )
        }

        LaunchedEffect(key1 = selectedPosition) {
            animated.animateTo(
                targetValue = itemsWeight.getStartPositionOffset(
                    currentPosition = selectedPosition,
                    margin = 30.dp.value
                ).startPosition,
                animationSpec = spring(
                    stiffness = Spring.StiffnessLow,
                    dampingRatio = Spring.DampingRatioLowBouncy
                )
            )
        }

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

            drawLine(
                strokeWidth = 3f,
                color = ColorUI.primaryBottomMenuButtonColor,
                start = Offset(
                    10f, animated.value + (3 * currentIndexLength.intValue)
                ),
                end = Offset(
                    10f,
                    animated.value + (itemsWeight[selectedPosition]
                        ?: 0f) - (12f * currentIndexLength.intValue)
                )
            )
        }

    }

}

@Preview
@Composable
private fun RecommendationMenuPreview() {
    val rec = RecommendationItemsList(RecommendationItems.items)
    RecommendationMenu(
        selectedPosition = 1 ,
        recommendationItemsList = rec,
        changePositionMenu = {})
}