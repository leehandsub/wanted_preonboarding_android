package com.example.wanted_pre_onboarding_android.ui.newsdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wanted_pre_onboarding_android.model.Article
import com.example.wanted_pre_onboarding_android.repository.saved.SavedRepository
import com.example.wanted_pre_onboarding_android.ui.common.Event
import kotlinx.coroutines.launch

class NewsDetailViewModel(private val savedRepository: SavedRepository) : ViewModel() {

    private val _addSavedEvent = MutableLiveData<Event<Unit>>()
    val addSavedEvent: LiveData<Event<Unit>> = _addSavedEvent

    private val _search = MutableLiveData<List<Article>>()
    val search: LiveData<List<Article>> = _search

    fun addSaved(article: Article) {
        viewModelScope.launch {
            savedRepository.addFavorite(article)
            _addSavedEvent.value = Event(Unit)
        }
    }

    fun deleteSaved(article: Article) {
        viewModelScope.launch {
            savedRepository.deleteFavorite(article)
            _addSavedEvent.value = Event(Unit)
        }
    }

    fun searchSaved(searchQuery: String) {
        viewModelScope.launch {
            _search.value = savedRepository.searchFavorite(searchQuery)
        }
    }

}
