package com.example.wanted_pre_onboarding_android.repository.saved

import com.example.wanted_pre_onboarding_android.model.Article
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SavedRepository(
    private val localDataSource: SavedLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    suspend fun addFavorite(article: Article) {
        withContext(ioDispatcher) {
            localDataSource.addFavorite(article)
        }
    }

    suspend fun getFavorite(): List<Article> {
        return withContext(ioDispatcher) {
            localDataSource.getFavorite()
        }
    }

    suspend fun deleteFavorite(article: Article) {
        withContext(ioDispatcher) {
            localDataSource.deleteFavorite(article)
        }
    }
    suspend fun searchFavorite(searchQuery : String) : List<Article>{
        return withContext(ioDispatcher) {
            localDataSource.searchFavorite(searchQuery)
        }
    }
}