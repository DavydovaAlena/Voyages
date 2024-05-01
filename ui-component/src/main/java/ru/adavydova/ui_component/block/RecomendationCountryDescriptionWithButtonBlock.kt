package ru.adavydova.ui_component.block

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.adavydova.ui_component.button.ButtonGoToTheDetail

@Composable
internal fun RecommendationCountryDescriptionWithButtonBlock(
    nameCountry: String,
    codeCountry: String?,
    goToTheDetails: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {

        RecommendationDescriptionBlock(
            modifier = Modifier.align(Alignment.TopStart),
            nameCountry = nameCountry,
            codeCountry = codeCountry
        )

        ButtonGoToTheDetail(
            modifier = Modifier.align(Alignment.BottomEnd),
            onClick = goToTheDetails
        )

    }
}
