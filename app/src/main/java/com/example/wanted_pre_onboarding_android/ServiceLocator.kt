package com.example.wanted_pre_onboarding_android

import com.example.wanted_pre_onboarding_android.network.ApiClient

object ServiceLocator {
    private var apiClient: ApiClient? = null

    fun provideApiClient(): ApiClient {
        return apiClient ?: kotlin.run {
            ApiClient.create().also {
                apiClient = it
            }
        }
    }
}