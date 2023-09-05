package com.example.onlinecoursesapp.ui.login_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginScreenViewModel : ViewModel() {
    private val _stateLogin = MutableStateFlow<Boolean>(false)
    val stateLogin: StateFlow<Boolean> = _stateLogin
    fun loadState(login: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateLogin.emit(login)
        }
    }
}