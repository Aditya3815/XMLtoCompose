package com.example.xmltocompose.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.xmltocompose.presentation.screens.courseList.CourseListScreen
import com.example.xmltocompose.viewmodel.CourseViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CourseListFragment : Fragment() {
    private val viewModel: CourseViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val courses = viewModel.courseList.value
                courses?.let {
                    CourseListScreen(
                        courses = courses,
                        onCourseClick = { selectedCourse ->
                            val action = CourseListFragmentDirections.actionCourseListToDetail(
                                selectedCourse.title,
                                selectedCourse.description
                            )
                            findNavController().navigate(action)
                        }
                    )
                }
            }
        }
    }
}

