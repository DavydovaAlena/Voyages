package ru.adavydova.voyages_navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.adavydova.voyages_navigation.bottom_menu.BottomNavigationItem
import ru.adavydova.voyages_navigation.route.Route


fun NavGraphBuilder.compassNavGraph(navController: NavController) {
    navigation(
        startDestination = Route.MapScreen.route,
        route = BottomNavigationItem.Compass.route
    ) {

        composable(route = Route.MapScreen.route){

        }

    }
}