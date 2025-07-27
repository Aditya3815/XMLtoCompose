package com.example.xmltocompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.xmltocompose.data.Course
import com.example.xmltocompose.repository.CourseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(
    repository: CourseRepository
) : ViewModel() {

    private val _courseList = MutableLiveData<List<Course>>()
    val courseList: LiveData<List<Course>> = _courseList

    init {
        _courseList.value = repository.getCourses()
    }
}

