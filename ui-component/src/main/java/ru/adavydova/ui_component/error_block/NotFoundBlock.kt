package ru.adavydova.ui_component.error_block

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.adavydova.utils.ColorUI
import ru.adavydova.utils.FontUI

@Composable
fun NotFoundBlock(
    modifier: Modifier = Modifier,
    title: String = "Destination not found",
    label: String = "Try search with a different keyword"
) {

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(.8f),
            lineHeight = 30.sp,
            color = ColorUI.recommendationTextColor,
            fontFamily = FontUI.MontserratExtraBold.toFontFamily(),
            fontSize = 26.sp,
            text = title
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            modifier = Modifier.fillMaxWidth(.8f),
            fontFamily = FontUI.MontserratBold.toFontFamily(),
            fontSize = 10.sp,
            text = label
        )
    }
}