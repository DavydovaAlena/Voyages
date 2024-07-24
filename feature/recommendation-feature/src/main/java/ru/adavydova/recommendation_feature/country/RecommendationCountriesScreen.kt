package ru.adavydova.recommendation_feature.country

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import ru.adavydova.recommendation_feature.mapper.toCountryUI
import ru.adavydova.recommendation_feature.menu.RecommendationContent
import ru.adavydova.recommendation_feature.menu.RecommendationItemsList
import ru.adavydova.recommendation_feature.menu.RecommendationMenu
import ru.adavydova.recommendation_feature.util.LazyRowWithPagingData
import ru.adavydova.ui_component.card.RecommendationCountryCard


@Composable
fun RecommendationScreen(
    modifier: Modifier = Modifier
) {

    val itemsMenu = remember {
        RecommendationItemsList()
    }
    var selectedPosition by rememberSaveable {
        mutableIntStateOf(0)
    }

    val currentDestination = remember(selectedPosition) {
        itemsMenu[selectedPosition]
    }

    Box(modifier = modifier.fillMaxSize()) {

        RecommendationMenu(
            modifier = Modifier.padding(top = 16.dp),
            recommendationItemsList = itemsMenu,
            selectedPosition = selectedPosition,
            changePositionMenu = { selectedPosition = it })

        RecommendationContent(
            recommendationItems = currentDestination, modifier = Modifier
                .fillMaxSize()
                .padding(start = 40.dp)
        )
    }
}

@Composable
fun RecommendationCountriesScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = hiltViewModel<RecommendationCountryViewModel>()
    val state = viewModel.recommendationCountryState.collectAsState()

    val itemsCountry = state.value.countries.collectAsLazyPagingItems()


    LazyRowWithPagingData(
        modifier = modifier.fillMaxSize(),
        items = itemsCountry,
        item = {
            RecommendationCountryCard(
                country = it.toCountryUI()
            )
        })
}