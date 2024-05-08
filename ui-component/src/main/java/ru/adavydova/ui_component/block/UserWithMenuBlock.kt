package ru.adavydova.ui_component.block

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.adavydova.ui_component.R
import ru.adavydova.utils.ColorUI

@Composable
fun UserWithMenuBlock(
    @DrawableRes icon: Int,
    userName: String,
    modifier: Modifier = Modifier,
    clickOnTheMenu: () -> Unit
) {

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        UserCardBlock(
            icon = icon,
            userName = userName
        )

        IconButton(onClick = clickOnTheMenu) {
            Icon(
                modifier = Modifier.size(17.dp),
                tint = ColorUI.hintColor,
                imageVector = ImageVector.vectorResource(R.drawable.menu_icon),
                contentDescription = null
            )
        }
    }
}

