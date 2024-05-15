package ru.adavydova.recommendation_feature.city

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import ru.adavydova.recommendation_feature.mapper.toCityUI
import ru.adavydova.recommendation_feature.util.LazyRowWithPagingData
import ru.adavydova.ui_component.card.RecommendationCityCard

@Composable
fun RecommendationCityScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = hiltViewModel<RecommendationCityViewModel>()
    val state = viewModel.recommendationCitiesState.collectAsState()

    val itemsCountry = state.value.countries.collectAsLazyPagingItems()

    LazyRowWithPagingData(
        modifier = modifier.fillMaxSize(),
        items = itemsCountry,
        item = {
            RecommendationCityCard(
                city = it.toCityUI()
            )
        })
}