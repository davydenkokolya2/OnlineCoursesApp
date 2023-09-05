package com.example.onlinecoursesapp.ui.login_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.onlinecoursesapp.databinding.FragmentLoginScreenBinding
import com.example.onlinecoursesapp.ui.MainViewModel
import com.example.onlinecoursesapp.util.Screens
import kotlinx.coroutines.launch

class LoginScreenFragment : Fragment() {

    private lateinit var binding: FragmentLoginScreenBinding
    private val loginScreenViewModel: LoginScreenViewModel by activityViewModels()
    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginScreenBinding.inflate(inflater, container, false)
        lifecycleScope.launch {
            loginScreenViewModel.stateLogin.collect {
                binding.ivStudentTrue.visibility = View.INVISIBLE
                binding.ivStudentFalse.visibility = View.INVISIBLE
                binding.ivTeacherTrue.visibility = View.INVISIBLE
                binding.ivTeacherFalse.visibility = View.INVISIBLE
                when(it) {
                    false -> {
                        binding.ivStudentTrue.visibility = View.VISIBLE
                        binding.ivTeacherFalse.visibility = View.VISIBLE
                    }
                    true -> {
                        binding.ivStudentFalse.visibility = View.VISIBLE
                        binding.ivTeacherTrue.visibility = View.VISIBLE
                    }
                }
            }
        }
        binding.ivTeacherFalse.setOnClickListener {
            loginScreenViewModel.loadState(true)
        }
        binding.ivStudentFalse.setOnClickListener {
            loginScreenViewModel.loadState(false)
        }
        binding.ivGetStarted.setOnClickListener {
            mainViewModel.loadState(Screens.HOME)
        }
        return binding.root
    }
}