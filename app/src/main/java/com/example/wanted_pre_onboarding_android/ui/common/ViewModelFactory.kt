package com.example.wanted_pre_onboarding_android.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wanted_pre_onboarding_android.ServiceLocator
import com.example.wanted_pre_onboarding_android.repository.category.CategoryNewsRemoteDataSource
import com.example.wanted_pre_onboarding_android.repository.category.CategoryNewsRepository
import com.example.wanted_pre_onboarding_android.repository.topnews.TopNewsRemoteDataSource
import com.example.wanted_pre_onboarding_android.repository.topnews.TopNewsRepository
import com.example.wanted_pre_onboarding_android.ui.category.CategoryNewsViewModel
import com.example.wanted_pre_onboarding_android.ui.topnews.TopNewsViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(CategoryNewsViewModel::class.java) -> {
                val repository =
                    CategoryNewsRepository(CategoryNewsRemoteDataSource(ServiceLocator.provideApiClient()))
                CategoryNewsViewModel(repository) as T
            }
            modelClass.isAssignableFrom(TopNewsViewModel::class.java) -> {
                val repository =
                    TopNewsRepository(TopNewsRemoteDataSource(ServiceLocator.provideApiClient()))
                TopNewsViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}