package ru.adavydova.voyages_navigation.bottom_menu

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable


@JvmInline
@Immutable
value class BottomNavigationState(
    val items: List<BottomNavigationItem> = BottomNavigationItem.bottomNavigationItems
): List<BottomNavigationItem> by items

@Immutable
sealed class BottomNavigationItem(
    val position: Int,
    val route: String,
    @DrawableRes val icon: Int,
    val label: String? = null
) {

    data object Home : BottomNavigationItem(
        position = 0,
        route = "home_bottom_nav_item",
        icon = ru.adavydova.ui_component.R.drawable.home_bottom_nav_icon
    )

    data object Compass : BottomNavigationItem(
        position = 1,
        route = "compass_bottom_nav_item",
        icon = ru.adavydova.ui_component.R.drawable.compass_bottom_nav_icon
    )

    data object Bookmark : BottomNavigationItem(
        position = 2,
        route = "bookmark_bottom_nav_item",
        icon = ru.adavydova.ui_component.R.drawable.bookmark_bottom_nav_icon
    )

    data object User : BottomNavigationItem(
        position = 3,
        route = "user_bottom_nav_item",
        icon = ru.adavydova.ui_component.R.drawable.user_bottom_nav_icon
    )

    companion object {
        val bottomNavigationItems = listOf<BottomNavigationItem>(
            Home,
            Compass,
            Bookmark,
            User
        )
    }

}