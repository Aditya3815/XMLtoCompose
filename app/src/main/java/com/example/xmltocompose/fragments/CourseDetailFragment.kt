package com.example.xmltocompose.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.xmltocompose.R
import com.example.xmltocompose.databinding.FragmentCourseDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseDetailFragment : Fragment() {

    private var _binding: FragmentCourseDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCourseDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args = arguments?.let {
            CourseDetailFragmentArgs.fromBundle(it)
        }
        binding.detailTitle.text = args?.title
        binding.detailDesc.text = args?.description
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
