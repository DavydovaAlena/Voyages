package ru.adavydova.ui_component.block

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.adavydova.utils.FontUI.CormorantMedium
import ru.adavydova.utils.recommendationTextColor

@Composable
internal fun RecommendationDescriptionBlock(
    nameCountry: String,
    codeCountry: String?,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        Text(
            color = recommendationTextColor,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(CormorantMedium),
            lineHeight = 16.sp,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            text = "Top recommendation"
        )


        TitleRecommendationBlock(nameCountry = nameCountry, codeCountry = codeCountry)


    }
}
