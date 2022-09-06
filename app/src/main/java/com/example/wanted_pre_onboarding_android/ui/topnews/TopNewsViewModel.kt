package com.example.wanted_pre_onboarding_android.ui.topnews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wanted_pre_onboarding_android.model.Article
import com.example.wanted_pre_onboarding_android.repository.topnews.TopNewsRepository
import com.example.wanted_pre_onboarding_android.ui.common.Event
import kotlinx.coroutines.launch

class TopNewsViewModel(private val topNewsRepository: TopNewsRepository) : ViewModel() {

    private val _items = MutableLiveData<List<Article>>()
    val items: LiveData<List<Article>> = _items

    private val _openNewsEvent = MutableLiveData<Event<Article>>()
    val openNewsEvent: LiveData<Event<Article>> = _openNewsEvent

    init {
        loadNews()
    }

    fun openNewsDetail(article: Article) {
        _openNewsEvent.value = Event(article)
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