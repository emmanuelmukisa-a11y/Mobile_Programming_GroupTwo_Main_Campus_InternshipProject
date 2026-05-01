package com.ndejje.momo.ourinternship.ui.viewmodel

sealed class MainViewModel {
    object Idle    : MainViewModel()
    object Loading : MainViewModel()
    data class Success(val username: String) : MainViewModel()
    data class Error(val message: String)   : MainViewModel()
}