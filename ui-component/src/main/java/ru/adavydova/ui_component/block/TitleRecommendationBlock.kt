package ru.adavydova.ui_component.block

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.adavydova.ui_component.card.CardFlagOfTheCountry
import ru.adavydova.utils.FontUI.CormorantBold
import ru.adavydova.utils.recommendationTextColor

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
                nameCountry = nameCountry
            )
        }

        false -> {
            TitleRecommendationWithFlag(
                modifier = modifier,
                nameCountry = nameCountry,
                codeCountry = codeCountry
            )
        }
    }
}

@Composable
private fun TitleRecommendationWithoutFlag(
    nameCountry: String,
    modifier: Modifier = Modifier
) {
    Text(
        fontFamily = FontFamily(CormorantBold),
        color = recommendationTextColor,
        lineHeight = 36.sp,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        fontWeight = FontWeight.Bold,
        fontSize = 35.sp,
        text = nameCountry
    )
}

@Composable
private fun TitleRecommendationWithFlag(
    nameCountry: String,
    codeCountry: String,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        CardFlagOfTheCountry(countryCode = codeCountry, modifier = Modifier.padding(top = 12.dp))

        Text(
            fontFamily = FontFamily(CormorantBold),
            color = recommendationTextColor,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp,
            fontSize = 35.sp,
            text = nameCountry
        )

    }
}