package ru.adavydova.recommendation_feature.menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import ru.adavydova.recommendation_feature.country.RecommendationCountriesScreen

sealed class RecommendationItems(
    val title: String,
    val content: @Composable (Modifier) -> Unit
) {
    companion object {
        val items =
            listOf(RecommendationDestination(), RecommendationCountry(), RecommendationCity())
    }

    class RecommendationCountry :
        RecommendationItems(
            title = "Countries",
            content = { RecommendationCountriesScreen(modifier = it) })

    class RecommendationDestination : RecommendationItems(
        title = "Destination",
        content = { RecommendationCountriesScreen(modifier = it) })

    class RecommendationCity :
        RecommendationItems(
            title = "Cities",
            content = { RecommendationCountriesScreen(modifier = it) })
}


@JvmInline
@Immutable
value class RecommendationItemsList(
    private val items: List<RecommendationItems>
) : List<RecommendationItems> by items


