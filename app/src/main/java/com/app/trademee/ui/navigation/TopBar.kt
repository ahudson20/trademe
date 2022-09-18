package com.app.trademee.ui.navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.trademee.ui.theme.Tasman500

@Composable
fun TopBar(
    navController: NavController,
    showToast: () -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        title = {
            Text(
                text = navBackStackEntry?.destination?.route.toString()
            )
        },
        actions = {
            when (navBackStackEntry?.destination?.route) {
                "Discover" -> {
                    IconButton(
                        onClick = {
                            showToast.invoke()
                        }
                    ) {
                        Icon(Icons.Filled.Search, contentDescription = "", tint = Tasman500)
                    }

                    IconButton(
                        onClick = {
                            showToast.invoke()
                        }
                    ) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "", tint = Tasman500)
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    navBackStackEntry?.destination?.route = "Discover"
    TopBar(navController, hiltViewModel())
}