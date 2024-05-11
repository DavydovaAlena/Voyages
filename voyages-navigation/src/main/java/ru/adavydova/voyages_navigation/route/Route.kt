package ru.adavydova.voyages_navigation.route

sealed class Route(val route: String ) {
    data object SplashNavGraph: Route(route = "splash_nav_graph")
    data object LottieSplashScreen: Route(route = "lottie_splash_screen")
    data object PreviewScreen: Route(route = "preview_screen")
    data object RecommendationNavGraph: Route(route = "recommendation_screen_nav_graph")
    data object RecommendationScreen: Route(route = "recommendation_screen")
    data object SearchNavGraph: Route(route = "search_nav_graph")
    data object SearchScreen: Route(route = "search_screen")
    data object FilterDialog: Route(route = "filter_dialog")
    data object  MapScreen: Route(route = "map_screen")
}