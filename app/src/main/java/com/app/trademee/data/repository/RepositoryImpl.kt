package com.app.trademee.data.repository

import com.app.trademee.data.network.ApiService

class RepositoryImpl(
    private val apiService: ApiService
): Repository {

    override suspend fun getData() = apiService.getData()

}