package ru.adavydova.voyages_navigation.bottom_menu

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.adavydova.utils.ColorUI


@Composable
fun BottomBarTabs(
    currentSelectedPosition: Int,
    modifier: Modifier = Modifier,
    state: BottomNavigationState,
    onTabSelected: (BottomNavigationItem) -> Unit
) {


    LaunchedEffect(key1 = currentSelectedPosition) {
        Log.d("Launxh", "launch")
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxSize()
    ) {
        for (item in state.items) {

            BottomBarTab(
                item = item,
                currentSelectedPosition = currentSelectedPosition
            ) {
                onTabSelected(it)
            }

        }
    }
}


@Composable
fun BottomBarTab(
    modifier: Modifier = Modifier,
    item: BottomNavigationItem,
    currentSelectedPosition: Int,
    onTabSelected: (BottomNavigationItem) -> Unit
) {


    val painter = rememberVectorPainter(image = ImageVector.vectorResource(item.icon))
    val containerColor by animateColorAsState(
        targetValue =
        when (currentSelectedPosition == item.position) {
            true -> ColorUI.primaryBottomMenuButtonColor
            false -> ColorUI.backgroundColor
        },
        animationSpec = spring(
            stiffness = Spring.StiffnessLow,
        ),
        label = ""
    )

    val contentColor by animateColorAsState(
        targetValue =
        when (currentSelectedPosition == item.position) {
            false -> ColorUI.unselectedButtonColor
            true -> ColorUI.backgroundColor
        },
        animationSpec = spring(
            stiffness = Spring.StiffnessLow,
        ),
        label = ""
    )


    FilledIconButton(
        shape = RoundedCornerShape(24.dp),
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Transparent
        ),
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .drawBehind {
                drawRect(color = containerColor) }
            .size(60.dp),
        onClick = { onTabSelected(item) }) {

        Icon(
            modifier = Modifier
                .size(22.dp)
                .drawBehind {
                    with(painter) {
                        draw(size, colorFilter = ColorFilter.tint(contentColor))
                    }
                },
            imageVector = ImageVector.vectorResource(id = item.icon),
            contentDescription = null
        )
    }
}
