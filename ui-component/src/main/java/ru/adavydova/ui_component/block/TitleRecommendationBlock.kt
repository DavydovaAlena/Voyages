package ru.adavydova.ui_component.block

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.adavydova.ui_component.card.CardFlagOfTheCountry
import ru.adavydova.utils.ColorUI
import ru.adavydova.utils.ColorUI.recommendationTextColor
import ru.adavydova.utils.FontUI.CormorantBold

@Composable
internal fun TitleRecommendationBlock(
    nameCountry: String,
    codeCountry: String?,
    modifier: Modifier = Modifier
) {
    when (codeCountry == null) {
        true -> {
            TitleRecommendationWithoutFlag(
                modifier = modifier,
                title = nameCountry
            )
        }

        false -> {
            TitleRecommendationWithFlag(
                modifier = modifier,
                title = nameCountry,
                codeCountry = codeCountry
            )
        }
    }
}

@Composable
internal fun TitleRecommendationWithoutFlag(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        fontFamily = FontFamily(CormorantBold),
        color = ColorUI.recommendationDestinationTextColor,
        lineHeight = 36.sp,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        fontWeight = FontWeight.Bold,
        fontSize = 35.sp,
        text = title
    )
}

@Composable
internal fun TitleRecommendationWithFlag(
    title: String,
    codeCountry: String,
    modifier: Modifier = Modifier,
    color: Color = ColorUI.recommendationDestinationTextColor
) {

    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        CardFlagOfTheCountry(countryCode = codeCountry, modifier = Modifier.padding(top = 12.dp))

        Text(
            fontFamily = FontFamily(CormorantBold),
            color = color,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp,
            fontSize = 35.sp,
            text = title
        )

    }
}