package com.example.wanted_pre_onboarding_android.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wanted_pre_onboarding_android.ServiceLocator
import com.example.wanted_pre_onboarding_android.repository.category.CategoryRemoteDataSource
import com.example.wanted_pre_onboarding_android.repository.category.CategoryRepository
import com.example.wanted_pre_onboarding_android.ui.category.CategoryViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository =
                    CategoryRepository(CategoryRemoteDataSource(ServiceLocator.provideApiClient()))
                CategoryViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}