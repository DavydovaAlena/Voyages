package ru.adavydova.voyages_navigation.bottom_menu

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.adavydova.utils.ColorUI


@Composable
fun BottomBarTabs(
    modifier: Modifier = Modifier,
    state: BottomNavigationState,
    onTabSelected: (BottomNavigationItem) -> Unit
) {

    val selectItem = state.items.find {
        it.position == state.position
    } ?: throw IllegalStateException("error state")



    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        for (item in state.items) {
            val isSelected = selectItem == item

            val animationColorContainer by animateColorAsState(
                targetValue = when (isSelected) {
                    true -> ColorUI.primaryBottomMenuButtonColor
                    false -> Color.Transparent
                },
                label = "animatedContainerColor",
                animationSpec = spring(
                    stiffness = Spring.StiffnessLow
                )
            )

            val animationColorIcon by animateColorAsState(
                targetValue = when (isSelected) {
                    true -> Color.Transparent
                    false -> ColorUI.primaryBottomMenuButtonColor
                },
                label = "animatedContainerColor",
                animationSpec = spring(
                    stiffness = Spring.StiffnessLow
                )
            )

            IconButton(
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = animationColorContainer,
                    contentColor = animationColorIcon
                ),
                modifier = Modifier.size(60.dp),
                onClick = { onTabSelected(item) }) {

                Icon(
                    modifier = Modifier
                        .size(22.dp),
                    imageVector = ImageVector.vectorResource(id = selectItem.icon),
                    contentDescription = null
                )
            }
        }
    }
}

