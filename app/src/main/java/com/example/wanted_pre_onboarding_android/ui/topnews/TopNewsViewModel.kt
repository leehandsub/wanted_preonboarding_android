package com.example.wanted_pre_onboarding_android.ui.topnews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wanted_pre_onboarding_android.model.Article
import com.example.wanted_pre_onboarding_android.repository.topnews.TopNewsRepository
import kotlinx.coroutines.launch

class TopNewsViewModel(private val topNewsRepository: TopNewsRepository) : ViewModel() {

    private val _items = MutableLiveData<List<Article>>()
    val items: LiveData<List<Article>> = _items

    init {
        loadNews()
    }

    private fun loadNews() {
        viewModelScope.launch {
            val news = topNewsRepository.getTopNews()
            news.let {
                _items.value = it.articles
            }
        }
    }
}