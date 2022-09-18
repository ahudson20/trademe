package com.app.trademee.data.model

import com.google.gson.annotations.SerializedName

data class ListingResponse(
    @SerializedName("List")
    val list: List<Listing>
)