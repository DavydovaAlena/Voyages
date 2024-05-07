package ru.adavydova.voyages_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import ru.adavydova.voyages_navigation.route.Route

@Composable
fun VoyagesNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
){

    NavHost(
        navController = navController,
        startDestination = Route.RecommendationNavGraph.route){

        splashNavGraph(navController)
        searchNavGraph(navController)
        recommendationNavGraph(navController)
    }
}


fun NavGraphBuilder.splashNavGraph(navController: NavController){
    navigation(
        startDestination = Route.LottieSplashScreen.route,
        route = Route.SplashNavGraph.route
    ){

        composable(route = Route.LottieSplashScreen.route){

        }

        composable(route = Route.PreviewScreen.route){

        }
    }
}

fun NavGraphBuilder.searchNavGraph(navController: NavController){
    navigation(
        startDestination = Route.SearchScreen.route,
        route = Route.SearchNavGraph.route
    ){

        composable(route = Route.SearchScreen.route){

        }

        dialog(route = Route.FilterDialog.route){

        }
    }
}

fun NavGraphBuilder.recommendationNavGraph(navController: NavController){
    navigation(
        startDestination = Route.RecommendationCountriesScreen.route,
        route = Route.RecommendationNavGraph.route
    ){

        composable(route = Route.RecommendationCountriesScreen.route){

        }

        composable(route = Route.RecommendationCitiesScreen.route){

        }

        composable(route = Route.RecommendationDestinationScreen.route){

        }
    }
}