package ru.adavydova.recommendation_feature.menu

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import ru.adavydova.recommendation_feature.city.RecommendationCityScreen
import ru.adavydova.recommendation_feature.country.RecommendationCountriesScreen


 @Composable
 fun RecommendationContent(
     modifier: Modifier = Modifier,
     recommendationItems: RecommendationItems
 ){
     when(recommendationItems){
         is RecommendationItems.RecommendationCity -> {
             RecommendationCityScreen(modifier = modifier)
         }
         is RecommendationItems.RecommendationCountry -> {
             RecommendationCountriesScreen(modifier = modifier)
         }
         is RecommendationItems.RecommendationDestination -> {
             RecommendationCountriesScreen(modifier = modifier)
         }
     }
 }

@Immutable
sealed class RecommendationItems(val title: String) {
    companion object {
        val items =
            listOf(RecommendationDestination, RecommendationCountry, RecommendationCity)
    }
    data object RecommendationCountry : RecommendationItems(title = "Countries")
    data object RecommendationDestination : RecommendationItems(title = "Destination")
    data object RecommendationCity : RecommendationItems(title = "Cities")
}


@JvmInline
@Immutable
value class RecommendationItemsList(
    private val items: List<RecommendationItems> = RecommendationItems.items
) : List<RecommendationItems> by items


