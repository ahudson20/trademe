package com.app.trademee.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title: String, var icon: ImageVector, var route: String) {
    object Discover: BottomNavItem(title = "Discover", icon = Icons.Filled.Search, route = "Discover")
    object Watchlist: BottomNavItem(title = "Watchlist", icon = Icons.Filled.List, route = "Watchlist")
    object Account: BottomNavItem(title = "My Trade Me", icon = Icons.Filled.AccountCircle, route = "My Trade Me")
}