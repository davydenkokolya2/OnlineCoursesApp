package com.example.onlinecoursesapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinecoursesapp.util.Screens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    private val _stateMain = MutableStateFlow<Screens>(Screens.ONBOARDING)
    val stateMain: StateFlow<Screens> = _stateMain
    fun loadState(screens: Screens) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateMain.emit(screens)
        }
    }
}