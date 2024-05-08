package ru.adavydova.voyages_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.adavydova.voyages_navigation.bottom_menu.BottomNavigationItem
import ru.adavydova.voyages_navigation.navgraph.bookmarkNavGraph
import ru.adavydova.voyages_navigation.navgraph.compassNavGraph
import ru.adavydova.voyages_navigation.navgraph.homeBottomMenuNavGraph
import ru.adavydova.voyages_navigation.navgraph.userBottomMenuNavGraph
import ru.adavydova.voyages_navigation.route.Route

@Composable
fun VoyagesNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = BottomNavigationItem.Home.route
    ) {

        splashNavGraph(navController)
        homeBottomMenuNavGraph(navController)
        userBottomMenuNavGraph(navController)
        compassNavGraph(navController)
        bookmarkNavGraph(navController)
    }
}


fun NavGraphBuilder.splashNavGraph(navController: NavController) {
    navigation(
        startDestination = Route.LottieSplashScreen.route,
        route = Route.SplashNavGraph.route
    ) {

        composable(route = Route.LottieSplashScreen.route) {
        }
        composable(route = Route.PreviewScreen.route) {
        }
    }
}

