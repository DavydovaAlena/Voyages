package ru.adavydova.voyages_navigation.bottom_menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.adavydova.utils.ColorUI
import ru.adavydova.voyages_navigation.VoyagesNavHost
import ru.adavydova.voyages_navigation.route.Route
import ru.adavydova.voyages_navigation.utils.navigateToBottomBar


@Composable
fun BottomNavigationApp() {
    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState()
    var selectedItem by rememberSaveable {
        mutableStateOf<BottomNavigationState>(BottomNavigationState(0))
    }

    val navigateToBottomBar: (BottomNavigationItem) -> Unit = {
        navController.navigateToBottomBar(it)
    }

    selectedItem = remember(backStackState) {
        when (backStackState.value?.destination?.parent?.route) {
            BottomNavigationItem.Home.route -> BottomNavigationState(0)
            BottomNavigationItem.Compass.route -> BottomNavigationState(1)
            BottomNavigationItem.Bookmark.route -> BottomNavigationState(2)
            BottomNavigationItem.User.route -> BottomNavigationState(3)
            else -> BottomNavigationState(0)
        }
    }

    val isBottomBarVisible = remember(backStackState) {
        backStackState.value?.destination?.route == Route.RecommendationDestinationScreen.route ||
                backStackState.value?.destination?.route == Route.RecommendationCitiesScreen.route ||
                backStackState.value?.destination?.route == Route.RecommendationCountriesScreen.route
    }

    Scaffold(
        containerColor = ColorUI.backgroundColor,
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(vertical = 30.dp, horizontal = 52.dp)
                ) {
                    BottomBarTabs(
                        modifier = Modifier.fillMaxSize(),
                        state = selectedItem,
                        onTabSelected = {
                            navigateToBottomBar(it)
                        })
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = it.calculateBottomPadding(),
                    top = it.calculateTopPadding()
                )
        ) {
            VoyagesNavHost(
                modifier = Modifier.fillMaxSize(),
                navController = navController
            )
        }
    }


}