package com.example.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.room.KidsDatabaseRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val repository = KidsDatabaseRepository(application)

    var currentLang by mutableStateOf("en")
        private set

    var totalStars by mutableStateOf(20)
        private set

    init {
        viewModelScope.launch {
            repository.initializeCacheIfNeeded()
        }
    }

    fun updateLanguage(lang: String) {
        currentLang = lang
    }

    fun addStars(amount: Int) {
        totalStars += amount
    }
}
