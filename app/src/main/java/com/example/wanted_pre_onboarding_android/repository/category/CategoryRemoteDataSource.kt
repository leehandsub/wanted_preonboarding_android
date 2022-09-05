package com.example.wanted_pre_onboarding_android.repository.category

import com.example.wanted_pre_onboarding_android.model.NewsResponse
import com.example.wanted_pre_onboarding_android.network.ApiClient


class CategoryRemoteDataSource(private val apiClient: ApiClient) : CategoryDataSource {

    override suspend fun getCategories(category: String): NewsResponse {
        return apiClient.getCategory(category)
    }
}