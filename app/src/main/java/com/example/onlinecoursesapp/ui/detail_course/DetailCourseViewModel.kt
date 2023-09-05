package com.example.onlinecoursesapp.ui.detail_course

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailCourseViewModel : ViewModel() {
    private val _stateDetailCourse = MutableStateFlow<MutableList<Int>>(mutableListOf(0, 0, 0,0))
    val stateDetailCourse: StateFlow<MutableList<Int>> = _stateDetailCourse
    fun loadState(position: Int, value: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val list = _stateDetailCourse.value.toMutableList()
            list[position] = value
            _stateDetailCourse.emit(list)
        }
    }
}