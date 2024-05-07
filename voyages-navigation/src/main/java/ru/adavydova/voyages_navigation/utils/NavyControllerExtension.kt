package ru.adavydova.voyages_navigation.utils

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import ru.adavydova.voyages_navigation.bottom_menu.BottomNavigationItem


fun NavController.navigateToBottomBar(navigationItem: BottomNavigationItem){
   navigate(navigationItem.route){
       popUpTo(this@navigateToBottomBar.graph.findStartDestination().id){
           saveState = true
       }
       launchSingleTop = true
       restoreState = true
   }
}