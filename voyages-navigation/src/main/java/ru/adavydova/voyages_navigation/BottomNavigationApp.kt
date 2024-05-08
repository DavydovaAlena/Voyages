package ru.adavydova.voyages_navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.adavydova.ui_component.block.SearchState
import ru.adavydova.ui_component.top_bar.RecommendationTopBar
import ru.adavydova.utils.ColorUI
import ru.adavydova.voyages_navigation.bottom_menu.BottomBarTabs
import ru.adavydova.voyages_navigation.bottom_menu.BottomNavigationItem
import ru.adavydova.voyages_navigation.bottom_menu.BottomNavigationState
import ru.adavydova.voyages_navigation.utils.navigateToBottomBar


@Composable
fun BottomNavigationApp(modifier: Modifier) {
    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var currentPosition by remember {
        mutableIntStateOf(0)
    }

    val navigateToBottomBar: (BottomNavigationItem) -> Unit = {
        navController.navigateToBottomBar(it)
    }

    val menuState = remember {
        BottomNavigationState(BottomNavigationItem.bottomNavigationItems)
    }

    currentPosition = remember(backStackState) {
        when (backStackState?.destination?.parent?.route) {
            BottomNavigationItem.Home.route -> 0
            BottomNavigationItem.Compass.route ->1
            BottomNavigationItem.Bookmark.route -> 2
            BottomNavigationItem.User.route -> 3
            else -> 0
        }
    }

    Scaffold(
        containerColor = ColorUI.backgroundColor,
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 18.dp, horizontal = 48.dp)
                    .height(60.dp)
            ) {
                BottomBarTabs(
                    currentSelectedPosition = currentPosition,
                    modifier = Modifier.fillMaxWidth(),
                    state = menuState,
                    onTabSelected = {
                        navigateToBottomBar(it)
                    })
            }

        },
        topBar = {
            RecommendationTopBar(
                goOnRequest = {},
                searchState = SearchState.DISABLE,
                updateSearchState = {})
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