package com.example.wanted_pre_onboarding_android.database

import androidx.room.*
import com.example.wanted_pre_onboarding_android.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Query("SELECT * FROM article")
    suspend fun favoriteLoad(): List<Article>

    @Query("SELECT * FROM article WHERE url_to_image LIKE :searchQuery")
    suspend fun searchDatabase(searchQuery : String) : List<Article>

    @Delete
    suspend fun delete(article: Article)
}
