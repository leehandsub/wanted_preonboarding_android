package com.example.wanted_pre_onboarding_android.repository.topnews

import com.example.wanted_pre_onboarding_android.model.NewsResponse
import com.example.wanted_pre_onboarding_android.network.ApiClient

class TopNewsRemoteDataSource(private val apiClient: ApiClient) : TopNewsDataSource {
    override suspend fun getTopNews(): NewsResponse {
        return apiClient.getTopNews()
    }
}
