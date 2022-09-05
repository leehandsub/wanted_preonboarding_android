package com.example.wanted_pre_onboarding_android.repository.topnews

import com.example.wanted_pre_onboarding_android.model.NewsResponse

interface TopNewsDataSource {
    suspend fun getTopNews(): NewsResponse
}