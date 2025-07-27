package com.example.xmltocompose.presentation.screens.courseList

import android.view.Surface
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.xmltocompose.data.Course

@Composable
fun CourseListScreen(
    courses: List<Course>,
    onCourseClick: (Course) -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(courses) { course ->
                CourseItem(course = course, onClick = { onCourseClick(course) })
            }
        }
    }
}

@Composable
fun CourseItem(course: Course, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = course.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = course.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview
@Composable
fun CourseListScreenPreview() {
    val sampleCourses = listOf(
        Course("Course 1", "Description of Course 1"),
        Course("Course 2", "Description of Course 2"),
        Course("Course 3", "Description of Course 3")
    )

    CourseListScreen(courses = sampleCourses, onCourseClick = {})
}