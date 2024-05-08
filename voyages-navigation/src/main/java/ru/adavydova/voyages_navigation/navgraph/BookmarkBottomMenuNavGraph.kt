package ru.adavydova.voyages_navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import ru.adavydova.voyages_navigation.bottom_menu.BottomNavigationItem
import ru.adavydova.voyages_navigation.route.Route

fun NavGraphBuilder.bookmarkNavGraph(navController: NavController) {
    navigation(
        startDestination = Route.RecommendationNavGraph.route,
        route = BottomNavigationItem.Bookmark.route
    ) {


    }
}