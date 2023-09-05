package com.example.onlinecoursesapp.ui.detail_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.onlinecoursesapp.databinding.FragmentDetailScreenBinding
import com.example.onlinecoursesapp.ui.MainViewModel
import com.example.onlinecoursesapp.ui.home_screen.HomeScreenViewModel
import com.example.onlinecoursesapp.util.Constants
import com.example.onlinecoursesapp.util.Screens

class DetailScreenFragment : Fragment() {

    private lateinit var binding: FragmentDetailScreenBinding
    private val detailScreenViewModel: DetailScreenViewModel by activityViewModels()
    private val homeScreenViewModel: HomeScreenViewModel by activityViewModels()
    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailScreenBinding.inflate(inflater, container, false)
        val i = homeScreenViewModel.stateHome.value
        val j = detailScreenViewModel.stateDetail.value

        binding.tvTitleCourse.setText( Constants.courses[i][j].title)
        binding.tvDescriptionCourse.setText(Constants.courses[i][j].description)
        binding.tvTitleContent1.setText( Constants.courses[i][j].title_1)
        binding.tvTitleContent2.setText(Constants.courses[i][j].title_2)
        binding.tvTitleContent3.setText(Constants.courses[i][j].title_3)
        binding.tvTitleContent4.setText(Constants.courses[i][j].title_4)

        binding.btnBackDetail.setOnClickListener {
            mainViewModel.loadState(Screens.HOME)
        }
        binding.btnGetThisCourse.setOnClickListener {
            mainViewModel.loadState(Screens.DETAIL_COURSE)
        }
        return binding.root
    }


}