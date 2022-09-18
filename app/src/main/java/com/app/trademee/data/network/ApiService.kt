package com.app.trademee.data.network

import com.app.trademee.data.model.ListingResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("v1/listings/latest.json?rows=20&photo_size=Large")
    suspend fun getData(): Response<ListingResponse>
}