package com.app.trademee.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.app.trademee.data.model.Listing
import com.app.trademee.logic.state.MainState
import com.app.trademee.ui.card.CardContainer
import com.app.trademee.ui.loading.LoadingScreen
import java.math.BigDecimal

@Composable
fun DiscoverScreen(
    state: MainState,
    onCardClick: () -> Unit
) {
    when(state) {
        is MainState.Loading -> LoadingScreen()
        is MainState.Success -> CardContainer(listings = state.listings, onCardClick = onCardClick)

        // TODO: make error screen
        is MainState.Error -> Text(text = "error")
    }
}

@Preview(showBackground = true)
@Composable
fun DiscoverScreenPreview() {
    DiscoverScreen(
        state = MainState.Success(listOf(
            Listing(
                listingId = 1,
                title = "title",
                region = "region",
                pictureHref = "href",
                buyNowPrice = BigDecimal.TEN,
                displayPrice = "3",
                isClassified = false
            ))),
        onCardClick = {}
    )
}