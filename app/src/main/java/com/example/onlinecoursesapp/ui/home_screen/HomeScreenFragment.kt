package com.example.onlinecoursesapp.ui.home_screen

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.onlinecoursesapp.R
import com.example.onlinecoursesapp.databinding.FragmentHomeScreenBinding
import com.example.onlinecoursesapp.ui.MainViewModel
import com.example.onlinecoursesapp.ui.detail_screen.DetailScreenViewModel
import com.example.onlinecoursesapp.util.Constants
import com.example.onlinecoursesapp.util.Screens
import kotlinx.coroutines.launch

class HomeScreenFragment : Fragment() {

    private val homeScreenViewModel: HomeScreenViewModel by activityViewModels()
    private lateinit var binding: FragmentHomeScreenBinding
    private val detailScreenViewModel: DetailScreenViewModel by activityViewModels()
    private val mainViewModel: MainViewModel by activityViewModels()
    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        binding.tvCategoriesCard1.setText(Constants.categories[0])
        binding.tvCategoriesCard2.setText(Constants.categories[1])
        binding.tvCategoriesCard3.setText(Constants.categories[2])
        binding.tvCategoriesCard4.setText(Constants.categories[3])
        binding.tvCategoriesCard5.setText(Constants.categories[4])

        lifecycleScope.launch {
            homeScreenViewModel.stateHome.collect {
                binding.ivCategoriesCard1.setImageResource(R.drawable.icon_grey_rectangle)
                binding.ivCategoriesCard2.setImageResource(R.drawable.icon_grey_rectangle)
                binding.ivCategoriesCard3.setImageResource(R.drawable.icon_grey_rectangle)
                binding.ivCategoriesCard4.setImageResource(R.drawable.icon_grey_rectangle)
                binding.ivCategoriesCard5.setImageResource(R.drawable.icon_grey_rectangle)
                binding.tvCategoriesCard1.setTextColor(R.color.dark_grey)
                binding.tvCategoriesCard2.setTextColor(R.color.dark_grey)
                binding.tvCategoriesCard3.setTextColor(R.color.dark_grey)
                binding.tvCategoriesCard4.setTextColor(R.color.dark_grey)
                binding.tvCategoriesCard5.setTextColor(R.color.dark_grey)

                binding.ivImageCategoriesCard1.setImageResource(Constants.courses[it][0].image)
                binding.tvTitleCourseCard1.setText(Constants.courses[it][0].title)
                binding.tvLevelCard1.setText(Constants.courses[it][0].level)
                binding.ivImageCategoriesCard2.setImageResource(Constants.courses[it][0].image)
                binding.tvTitleCourseCard2.setText(Constants.courses[it][1].title)
                binding.tvLevelCard2.setText(Constants.courses[it][1].level)
                binding.ivImageCategoriesCard3.setImageResource(Constants.courses[it][0].image)
                binding.tvTitleCourseCard3.setText(Constants.courses[it][2].title)
                binding.tvLevelCard3.setText(Constants.courses[it][2].level)
                binding.ivImageCategoriesCard4.setImageResource(Constants.courses[it][0].image)
                binding.tvTitleCourseCard4.setText(Constants.courses[it][3].title_1)
                binding.tvLevelCard4.setText(Constants.courses[it][3].level)
                when(it) {
                    0 -> {
                        binding.ivCategoriesCard1.setImageResource(R.drawable.icon_purple_rectangle)
                        binding.tvCategoriesCard1.setTextColor(Color.WHITE)
                    }
                    1 -> {
                        binding.ivCategoriesCard2.setImageResource(R.drawable.icon_purple_rectangle)
                        binding.tvCategoriesCard2.setTextColor(Color.WHITE)
                    }
                    2 -> {
                        binding.ivCategoriesCard3.setImageResource(R.drawable.icon_purple_rectangle)
                        binding.tvCategoriesCard3.setTextColor(Color.WHITE)
                    }
                    3 -> {
                        binding.ivCategoriesCard4.setImageResource(R.drawable.icon_purple_rectangle)
                        binding.tvCategoriesCard4.setTextColor(Color.WHITE)
                    }
                    4 -> {
                        binding.ivCategoriesCard5.setImageResource(R.drawable.icon_purple_rectangle)
                        binding.tvCategoriesCard5.setTextColor(Color.WHITE)
                    }
                }
            }
        }

        binding.btnCard1.setOnClickListener {
            detailScreenViewModel.loadState(0)
            mainViewModel.loadState(Screens.DETAIL)
        }
        binding.btnCard2.setOnClickListener {
            detailScreenViewModel.loadState(1)
            mainViewModel.loadState(Screens.DETAIL)
        }
        binding.btnCard3.setOnClickListener {
            detailScreenViewModel.loadState(2)
            mainViewModel.loadState(Screens.DETAIL)
        }
        binding.btnCard4.setOnClickListener {
            detailScreenViewModel.loadState(3)
            mainViewModel.loadState(Screens.DETAIL)
        }
        binding.ivCategoriesCard1.setOnClickListener {
            homeScreenViewModel.loadState(0)
        }
        binding.ivCategoriesCard2.setOnClickListener {
            homeScreenViewModel.loadState(1)
        }
        binding.ivCategoriesCard3.setOnClickListener {
            homeScreenViewModel.loadState(2)
        }
        binding.ivCategoriesCard4.setOnClickListener {
            homeScreenViewModel.loadState(3)
        }
        binding.ivCategoriesCard5.setOnClickListener {
            homeScreenViewModel.loadState(4)
        }
        binding.btnHome.setOnClickListener {
            mainViewModel.loadState(Screens.LOGIN)
        }
        return binding.root
    }

}