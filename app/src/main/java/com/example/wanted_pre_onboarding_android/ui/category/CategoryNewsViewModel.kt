package com.example.wanted_pre_onboarding_android.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wanted_pre_onboarding_android.model.Article
import com.example.wanted_pre_onboarding_android.repository.category.CategoryNewsRepository
import kotlinx.coroutines.launch

class CategoryNewsViewModel(private val categoryRepository: CategoryNewsRepository) : ViewModel() {
    private val _items = MutableLiveData<List<Article>>()
    val items: LiveData<List<Article>> = _items

    fun loadCategory(category: String) {
        viewModelScope.launch {
            val news = categoryRepository.getCategories(category)
            news.let {
                _items.value = it.articles
            }
        }
    }

}