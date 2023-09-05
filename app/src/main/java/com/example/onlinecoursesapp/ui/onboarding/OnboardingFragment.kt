package com.example.onlinecoursesapp.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.onlinecoursesapp.databinding.FragmentOnboardingBinding
import com.example.onlinecoursesapp.ui.MainViewModel
import com.example.onlinecoursesapp.util.Screens

class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        binding.textView6.setOnClickListener {
            mainViewModel.loadState(Screens.LOGIN)
        }
        return binding.root
    }
}