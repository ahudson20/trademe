package com.app.trademee.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.trademee.logic.state.MainState
import com.app.trademee.ui.screens.AccountScreen
import com.app.trademee.ui.screens.DiscoverScreen
import com.app.trademee.ui.screens.WatchlistScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    state: MainState,
    showToast: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Discover.route
    ) {

        composable(
            route = BottomNavItem.Discover.route
        ) {
            DiscoverScreen(
                state = state,
                onCardClick = showToast,
            )
        }

        composable(
            route = BottomNavItem.Watchlist.route
        ) {
            WatchlistScreen()
        }

        composable(
            route = BottomNavItem.Account.route
        ) {
            AccountScreen()
        }

    }
}