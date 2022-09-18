package com.app.trademee

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.app.trademee.logic.MainViewModel
import com.app.trademee.ui.navigation.BottomNavigation
import com.app.trademee.ui.navigation.NavGraph
import com.app.trademee.ui.navigation.TopBar
import com.app.trademee.ui.theme.TrademeeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrademeeTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                val stateFromViewModel = viewModel.state.collectAsState().value
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = { TopBar(navController = navController, showToast = ::showToast) },
                    bottomBar = { BottomNavigation(navController = navController) }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        NavGraph(
                            navController = navController,
                            state = stateFromViewModel,
                            showToast = ::showToast
                        )
                    }
                }
            }
        }
    }

    private fun showToast() {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(this, "toast", Toast.LENGTH_SHORT).show()
        }
    }
}