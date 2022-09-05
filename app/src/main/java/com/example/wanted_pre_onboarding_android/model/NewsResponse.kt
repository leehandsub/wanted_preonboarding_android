package com.example.wanted_pre_onboarding_android.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
