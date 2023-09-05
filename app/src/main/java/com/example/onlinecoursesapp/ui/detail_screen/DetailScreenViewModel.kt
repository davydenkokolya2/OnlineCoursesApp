package com.example.onlinecoursesapp.ui.detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailScreenViewModel : ViewModel() {
    private val _stateDetail = MutableStateFlow<Int>(0)
    val stateDetail: StateFlow<Int> = _stateDetail
    fun loadState(detail: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateDetail.emit(detail)
        }
    }
}