package ru.adavydova.ui_component.top_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecommendationTopBar(
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(33.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = 31.dp,
                bottom = 18.dp
            )
            .height(140.dp)
    ) {
        TopBarUserWithMenuPart()
        TopBarTitleWithSearchPart(
            title = "Recommendation",
            clickOnTheSearchButton = {

            })
    }
}

@Composable
fun TopBarTitleWithSearchPart(
    modifier: Modifier = Modifier,
    clickOnTheSearchButton: ()->Unit,
    title: String
) {

    Row(modifier = modifier.fillMaxWidth()) {

    }
}

@Composable
fun TopBarAllowBackWithLabelPart(
    modifier: Modifier = Modifier
) {

}

@Composable
fun TopBarUserWithMenuPart(
    modifier: Modifier = Modifier
) {

}
