package ru.adavydova.ui_component.error_block

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.sp
import ru.adavydova.utils.ColorUI
import ru.adavydova.utils.FontUI

@Composable
fun ErrorRequestBlock(
    modifier: Modifier,
    error: String
) {
    Box(modifier = modifier.fillMaxSize()){
        Text(
            modifier = Modifier
                .fillMaxWidth(.8f)
                .align(Alignment.CenterStart),
            lineHeight = 30.sp,
            color = ColorUI.recommendationTextColor,
            fontFamily = FontUI.MontserratExtraBold.toFontFamily(),
            fontSize = 26.sp,
            text = error
        )
    }

}