package com.example.wanted_pre_onboarding_android.ui.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wanted_pre_onboarding_android.model.Article

class CommonViewModel() : ViewModel() {
    private val _openNewsEvent = MutableLiveData<Event<Article>>()
    val openNewsEvent: LiveData<Event<Article>> = _openNewsEvent

    fun openNewsDetail(article: Article) {
        _openNewsEvent.value = Event(article)
    }
}
