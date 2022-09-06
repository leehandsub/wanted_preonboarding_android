package com.example.wanted_pre_onboarding_android.repository.saved

import com.example.wanted_pre_onboarding_android.model.Article

interface SavedDataSource {

    suspend fun addFavorite(article: Article)

    suspend fun getFavorite(): List<Article>

    suspend fun deleteFavorite(article: Article)

    suspend fun searchFavorite(searchQuery : String) : List<Article>
}