package com.example.wanted_pre_onboarding_android.ui.saved

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wanted_pre_onboarding_android.model.Article
import com.example.wanted_pre_onboarding_android.repository.saved.SavedRepository
import kotlinx.coroutines.launch

class SavedViewModel(private val savedRepository: SavedRepository) : ViewModel() {
    private val _save = MutableLiveData<List<Article>>()
    val saves: LiveData<List<Article>> = _save

    init {
        loadSaved()
    }

    private fun loadSaved() {
        viewModelScope.launch {
            _save.value = savedRepository.getFavorite()
        }
    }
}
