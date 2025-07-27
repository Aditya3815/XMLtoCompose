package com.example.xmltocompose.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.xmltocompose.data.Course
import com.example.xmltocompose.databinding.ItemCourseBinding

class CourseAdapter(private val onClick: (Course) -> Unit) :
    ListAdapter<Course, CourseAdapter.CourseViewHolder>(DiffCallback()) {

    inner class CourseViewHolder(private val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(course: Course) {
            binding.courseTitle.text = course.title
            binding.courseDesc.text = course.description
            binding.root.setOnClickListener { onClick(course) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<Course>() {
        override fun areItemsTheSame(old: Course, new: Course) = old.title == new.title
        override fun areContentsTheSame(old: Course, new: Course) = old == new
    }
}
