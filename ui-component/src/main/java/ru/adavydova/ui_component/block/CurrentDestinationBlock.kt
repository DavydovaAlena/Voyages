package ru.adavydova.ui_component.block

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.adavydova.ui_component.R
import ru.adavydova.utils.ColorUI
import ru.adavydova.utils.FontUI

@Composable
fun CurrentDestinationBlock(
    numOfDestination: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {

        Icon(
            modifier = Modifier.size(14.dp),
            tint = Color.White,
            imageVector = ImageVector
                .vectorResource(id = R.drawable.destination_icon),
            contentDescription = null
        )

        Text(
            fontSize = 11.sp,
            color = Color.White,
            fontFamily = FontUI.MontserratBold.toFontFamily(),
            text = "$numOfDestination")

        Text(
            fontSize = 11.sp,
            color = ColorUI.recommendationTextColor,
            fontFamily = FontUI.MontserratBold.toFontFamily(),
            text = "Destination")

    }
}