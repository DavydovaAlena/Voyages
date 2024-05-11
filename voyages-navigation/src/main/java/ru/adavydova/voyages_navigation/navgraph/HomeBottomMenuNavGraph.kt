package ru.adavydova.voyages_navigation.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.navigation
import ru.adavydova.recommendation_feature.country.RecommendationScreen
import ru.adavydova.voyages_navigation.bottom_menu.BottomNavigationItem
import ru.adavydova.voyages_navigation.route.Route


fun NavGraphBuilder.homeBottomMenuNavGraph(navController: NavController) {
    navigation(
        startDestination = Route.RecommendationNavGraph.route,
        route = BottomNavigationItem.Home.route
    ) {
        searchNavGraph(navController)
        recommendationNavGraph(navController)
    }

}

fun NavGraphBuilder.searchNavGraph(navController: NavController) {
    navigation(
        startDestination = Route.SearchScreen.route,
        route = Route.SearchNavGraph.route
    ) {

        composable(route = Route.SearchScreen.route) {

        }

        dialog(route = Route.FilterDialog.route) {

        }
    }
}

fun NavGraphBuilder.recommendationNavGraph(navController: NavController) {
    navigation(
        startDestination = Route.RecommendationScreen.route,
        route = Route.RecommendationNavGraph.route
    ) {

        composable(route = Route.RecommendationScreen.route) {

            RecommendationScreen(
                modifier = Modifier
                    .padding(start = 34.dp)
                    .padding(vertical = 20.dp)
                    .fillMaxSize()
            )
        }

    }
}

