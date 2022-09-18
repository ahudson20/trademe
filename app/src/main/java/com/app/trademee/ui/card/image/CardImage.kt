package com.app.trademee.ui.card.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

@Composable
fun CardImage(
    url: String
) {
    AsyncImage(
        model = url,
        contentDescription = null
    )
}

@Preview(showBackground = true)
@Composable
fun CardImagePreview() {
    CardImage("https://example.com/image.jpg")
}