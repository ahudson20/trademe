package com.app.trademee.data.repository

import com.app.trademee.data.model.ListingResponse
import retrofit2.Response

interface Repository {
    suspend fun getData(): Response<ListingResponse>
}