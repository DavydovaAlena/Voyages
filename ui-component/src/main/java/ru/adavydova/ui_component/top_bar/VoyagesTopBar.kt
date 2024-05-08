package ru.adavydova.ui_component.top_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.adavydova.ui_component.R
import ru.adavydova.ui_component.block.RecommendationWithSearchBlock
import ru.adavydova.ui_component.block.SearchState
import ru.adavydova.ui_component.block.UserWithMenuBlock
import ru.adavydova.utils.ColorUI

@Composable
fun RecommendationTopBar(
    modifier: Modifier = Modifier,
    goOnRequest: (String) -> Unit,
    searchState: SearchState,
    updateSearchState: (SearchState) -> Unit,
    title: String = "Recommendation",
    hint: String = "ISearch your dream destination",
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 34.dp,
            )
            .wrapContentHeight()
    ) {
        UserWithMenuBlock(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 42.dp),
            icon = R.drawable.user_woman,
            userName = "Dsvlna_a",
            clickOnTheMenu = {})

        TopBarTitleWithSearchPart(
            title = title,
            hint = hint,
            updateSearchState = updateSearchState,
            goOnRequest = goOnRequest,
            searchState = searchState
        )
    }
}

@Composable
internal fun TopBarTitleWithSearchPart(
    modifier: Modifier = Modifier,
    goOnRequest: (String) -> Unit,
    searchState: SearchState,
    updateSearchState: (SearchState) -> Unit,
    title: String = "Recommendation",
    hint: String = "ISearch your dream destination",

    ) {

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        RecommendationWithSearchBlock(
            modifier = Modifier
                .padding(end = 42.dp)
                .fillMaxWidth(),
            text = title,
            hint = hint,
            updateSearchState = updateSearchState,
            goOnRequest = goOnRequest,
            searchState = searchState
        )

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = ColorUI.hintColor
        )
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

    Row() {

    }
}
