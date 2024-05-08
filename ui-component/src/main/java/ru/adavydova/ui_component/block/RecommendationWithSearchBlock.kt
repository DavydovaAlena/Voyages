package ru.adavydova.ui_component.block

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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

enum class SearchState {
    ENABLE, DISABLE
}

@Composable
internal fun RecommendationWithSearchBlock(
    modifier: Modifier = Modifier,
    text: String = "Recommendation",
    updateSearchState: (SearchState) -> Unit,
    hint: String = "ISearch your dream destination",
    goOnRequest: (String) -> Unit,
    searchState: SearchState
) {

    when (searchState) {
        SearchState.ENABLE -> {
            RecommendationWithEnableSearchBlock(
                modifier = modifier.fillMaxWidth(),
                hint = hint,
                updateSearchState = updateSearchState,
                goOnRequest = goOnRequest
            )
        }

        SearchState.DISABLE -> {
            RecommendationWithDisableSearchBlock(
                modifier = modifier.fillMaxWidth(),
                text = text,
                updateSearchState = updateSearchState
            )
        }
    }
}

@Composable
private fun RecommendationWithEnableSearchBlock(
    modifier: Modifier = Modifier,
    updateSearchState: (SearchState) -> Unit,
    goOnRequest: (String) -> Unit,
    hint: String,
) {

    val query = rememberSaveable() {
        mutableStateOf<String>("")
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        TextField(
            colors = TextFieldDefaults.colors(
                disabledContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                cursorColor = ColorUI.hintColor,
                disabledPlaceholderColor = ColorUI.hintColor,
                focusedPlaceholderColor = ColorUI.hintColor,
            ),
            label = {
                Text(
                    color = ColorUI.hintColor,
                    text = hint
                )
            },
            value = query.value,
            onValueChange = { query.value = it })

        IconButton(
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = ColorUI.primaryBottomMenuButtonColor,
                contentColor = ColorUI.backgroundColor
            ),
            modifier = Modifier
                .size(42.dp),
            onClick = { goOnRequest(query.value) }) {

            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null
            )
        }
    }


}

@Composable
private fun RecommendationWithDisableSearchBlock(
    modifier: Modifier = Modifier,
    updateSearchState: (SearchState) -> Unit,
    text: String,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Text(
            text = text,
            color = ColorUI.primaryBottomMenuButtonColor,
            fontSize = 22.sp,
            lineHeight = 24.sp,
            fontFamily = FontUI.MontserratExtraBold.toFontFamily()
        )

        IconButton(
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Color.Transparent,
                contentColor = ColorUI.primaryBottomMenuButtonColor
            ),
            modifier = Modifier
                .size(42.dp),
            onClick = { updateSearchState(SearchState.ENABLE) }) {

            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.search_icon),
                contentDescription = null
            )
        }
    }


}