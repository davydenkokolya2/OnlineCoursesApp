package com.example.onlinecoursesapp.ui.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {
    private val _stateHome = MutableStateFlow<Int>(0)
    val stateHome: StateFlow<Int> = _stateHome
    fun loadState(home: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateHome.emit(home)
        }
    }
}