package com.example.wanted_pre_onboarding_android.repository.topnews

import com.example.wanted_pre_onboarding_android.model.NewsResponse

class TopNewsRepository(
    private val remoteDataSource: TopNewsRemoteDataSource
) {
    suspend fun getTopNews(): NewsResponse {
        return remoteDataSource.getTopNews()
    }
}

