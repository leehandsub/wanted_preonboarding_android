package com.example.wanted_pre_onboarding_android.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wanted_pre_onboarding_android.model.Article

@Database(entities = [Article::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
}
