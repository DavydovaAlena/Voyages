package ru.adavydova.recommendation_feature.country

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import ru.adavydova.recommendation_feature.mapper.toCountryUI
import ru.adavydova.recommendation_feature.util.LazyRowWithPagingData
import ru.adavydova.ui_component.card.RecommendationCountryCard

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