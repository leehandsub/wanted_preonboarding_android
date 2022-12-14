package com.example.wanted_pre_onboarding_android.repository.category

import com.example.wanted_pre_onboarding_android.model.NewsResponse

interface CategoryNewsDataSource {
    suspend fun getCategories(category: String): NewsResponse
}
