package com.example.wanted_pre_onboarding_android.repository.saved

import com.example.wanted_pre_onboarding_android.database.ArticleDao
import com.example.wanted_pre_onboarding_android.model.Article

class SavedLocalDataSource(private val dao: ArticleDao) : SavedDataSource {

    override suspend fun addFavorite(article: Article) {
        dao.insert(article)
    }

    override suspend fun getFavorite(): List<Article> {
        return dao.favoriteLoad()
    }

    override suspend fun deleteFavorite(article: Article) {
        dao.delete(article)
    }
}