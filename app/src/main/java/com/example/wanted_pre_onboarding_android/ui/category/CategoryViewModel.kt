package com.example.wanted_pre_onboarding_android.ui.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wanted_pre_onboarding_android.model.NewsResponse
import com.example.wanted_pre_onboarding_android.repository.category.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {
    private val _items = MutableLiveData<NewsResponse>()
    val item: LiveData<NewsResponse> = _items

    fun loadCategory(category: String) {
        viewModelScope.launch {
            val response = categoryRepository.getCategories("business")
            Log.e("response", response.toString())//예외상황 설정
            //_items.value=categoryRepository.getCategories(category)
        }
    }
}