package com.example.wanted_pre_onboarding_android.repository.category

import com.example.wanted_pre_onboarding_android.model.NewsResponse


class CategoryNewsRepository(
    private val remoteDataSource: CategoryNewsRemoteDataSource
) {

    suspend fun getCategories(category: String): NewsResponse {
        return remoteDataSource.getCategories(category)
    }
}
