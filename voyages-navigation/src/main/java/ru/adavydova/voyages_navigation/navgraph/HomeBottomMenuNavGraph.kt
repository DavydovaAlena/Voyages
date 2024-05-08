package ru.adavydova.voyages_navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.navigation
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
        startDestination = Route.RecommendationCountriesScreen.route,
        route = Route.RecommendationNavGraph.route
    ) {

        composable(route = Route.RecommendationCountriesScreen.route) {

        }

        composable(route = Route.RecommendationCitiesScreen.route) {

        }

        composable(route = Route.RecommendationDestinationScreen.route) {

        }
    }
}

