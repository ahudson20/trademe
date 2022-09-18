package com.app.trademee.ui.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.trademee.data.model.Listing
import com.app.trademee.ui.card.image.CardImage
import java.math.BigDecimal

@Composable
fun CardContainer(
    listings: List<Listing>,
    onCardClick: () -> Unit
) {
    LazyColumn {
        items(listings, key = {it.listingId}) { listing ->
            SingleCard(
                listing = listing,
                onCardClick = onCardClick
            )
        }
    }
}

@Composable
fun SingleCard(
    listing: Listing,
    onCardClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clickable { onCardClick.invoke() }
    ) {
        Row {
            CardImage(url = listing.pictureHref.toString())
            Column {
                Text(
                    text = listing.region.toString()
                )
                Text(
                    text = listing.title.toString()
                )
                PriceText(listing)
            }
        }
    }
}

@Composable
private fun PriceText(
    listing: Listing,
) {
    if (listing.isClassified) {
        Text(text = "Asking price " + listing.displayPrice)
    } else {
        Text(text = "Current price " + listing.displayPrice)
        if (listing.buyNowPrice != null) {
            Text(text = "Buy Now price " + listing.buyNowPrice.toString())
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PriceTextPreview() {
    PriceText(
        listing = Listing(
            listingId = 1,
            title = "title",
            region = "region",
            pictureHref = "href",
            buyNowPrice = BigDecimal.TEN,
            displayPrice = "3",
            isClassified = false
        )
    )
}