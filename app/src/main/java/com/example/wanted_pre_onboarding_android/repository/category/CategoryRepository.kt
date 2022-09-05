package com.example.wanted_pre_onboarding_android.repository.category

import com.example.wanted_pre_onboarding_android.model.NewsResponse


class CategoryRepository(
    private val remoteDataSource: CategoryRemoteDataSource
) {

    suspend fun getCategories(category: String): NewsResponse {
        return remoteDataSource.getCategories(category)
    }
}
