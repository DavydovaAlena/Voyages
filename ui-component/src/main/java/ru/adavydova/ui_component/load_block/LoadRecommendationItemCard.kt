package ru.adavydova.ui_component.load_block

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.adavydova.utils.shimmerLoadingAnimation

@Composable
fun LoadRecommendationItemCard(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .clip(RoundedCornerShape(22.dp))
        .fillMaxHeight()
        .width(266.dp)
        .shimmerLoadingAnimation())

}