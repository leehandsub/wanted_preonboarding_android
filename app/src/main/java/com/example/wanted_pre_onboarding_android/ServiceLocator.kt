package com.example.wanted_pre_onboarding_android

import android.content.Context
import androidx.room.Room
import com.example.wanted_pre_onboarding_android.database.AppDatabase
import com.example.wanted_pre_onboarding_android.network.ApiClient
import com.example.wanted_pre_onboarding_android.repository.saved.SavedLocalDataSource
import com.example.wanted_pre_onboarding_android.repository.saved.SavedRepository

object ServiceLocator {
    private var apiClient: ApiClient? = null
    private var database: AppDatabase? = null
    private var savedRepository : SavedRepository? = null

    fun provideApiClient(): ApiClient {
        return apiClient ?: kotlin.run {
            ApiClient.create().also {
                apiClient = it
            }
        }
    }
    private fun provideDatabase(applicationContext: Context): AppDatabase {
        return database ?: kotlin.run {
            Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "news-local"
            ).build().also {
                database = it
            }
        }
    }

    fun provideSavedRepository(context: Context): SavedRepository {
        return savedRepository ?: kotlin.run {
            val dao = provideDatabase(context.applicationContext).articleDao()
            SavedRepository(SavedLocalDataSource(dao)).also {
                savedRepository = it
            }
        }
    }
}