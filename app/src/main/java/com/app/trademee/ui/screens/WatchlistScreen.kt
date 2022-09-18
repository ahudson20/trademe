package com.app.trademee.ui.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WatchlistScreen(
) {
    Text(
        text = "Watchlist Screen",
        color = MaterialTheme.colors.onBackground,
    )
}

@Preview(showBackground = true)
@Composable
fun WatchlistScreenPreview() {
    WatchlistScreen()
}