package com.example.xmltocompose.repository

import com.example.xmltocompose.data.Course
import javax.inject.Inject

interface CourseRepository {
    fun getCourses(): List<Course>
}

class FakeCourseRepository @Inject constructor() : CourseRepository {
    override fun getCourses(): List<Course> = listOf(
        Course("Jetpack Compose", "Modern toolkit"),
        Course("Kotlin", "Modern language"),
        Course("Hilt", "DI for Android")
    )
}