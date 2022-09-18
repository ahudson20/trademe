package com.app.trademee.ui.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AccountScreen(
) {
    Text(
        text = "My Trade Me Screen",
        color = MaterialTheme.colors.onBackground,
    )
}

@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    AccountScreen()
}