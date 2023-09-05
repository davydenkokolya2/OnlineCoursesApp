package com.example.onlinecoursesapp.ui.detail_course

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.onlinecoursesapp.databinding.FragmentDetailCourseBinding
import com.example.onlinecoursesapp.ui.MainViewModel
import com.example.onlinecoursesapp.ui.detail_screen.DetailScreenViewModel
import com.example.onlinecoursesapp.ui.home_screen.HomeScreenViewModel
import com.example.onlinecoursesapp.util.Constants
import com.example.onlinecoursesapp.util.Screens
import kotlinx.coroutines.launch

class DetailCourseFragment : Fragment() {

    private lateinit var binding: FragmentDetailCourseBinding
    private val detailScreenViewModel: DetailScreenViewModel by activityViewModels()
    private val homeScreenViewModel: HomeScreenViewModel by activityViewModels()
    private val detailCourseViewModel: DetailCourseViewModel by activityViewModels()
    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailCourseBinding.inflate(inflater, container, false)

        val i = homeScreenViewModel.stateHome.value
        val j = detailScreenViewModel.stateDetail.value

        lifecycleScope.launch {
            detailCourseViewModel.stateDetailCourse.collect {
                binding.tvDescriptionContent1Detail.visibility = View.GONE
                binding.tvDescriptionContent2Detail.visibility = View.GONE
                binding.tvDescriptionContent3Detail.visibility = View.GONE
                binding.tvDescriptionContent4Detail.visibility = View.GONE
                binding.ivArrow1.rotation = 0F
                binding.ivArrow2.rotation = 0F
                binding.ivArrow3.rotation = 0F
                binding.ivArrow4.rotation = 0F
                Log.d("test", "test")
                if (it[0] == 1) {
                    binding.tvDescriptionContent1Detail.visibility = View.VISIBLE
                    binding.ivArrow1.rotation = 180F
                }
                if (it[1] == 1) {
                    binding.tvDescriptionContent2Detail.visibility = View.VISIBLE
                    binding.ivArrow2.rotation = 180F
                }
                if (it[2] == 1) {
                    binding.tvDescriptionContent3Detail.visibility = View.VISIBLE
                    binding.ivArrow3.rotation = 180F
                }
                if (it[3] == 1) {
                    binding.tvDescriptionContent4Detail.visibility = View.VISIBLE
                    binding.ivArrow4.rotation = 180F
                }
            }
        }
        binding.tvTitleContent1Detail.setText(Constants.courses[i][j].title_1)
        binding.tvDescriptionContent1Detail.setText(Constants.courses[i][j].description_1)

        binding.tvTitleContent2Detail.setText(Constants.courses[i][j].title_2)
        binding.tvDescriptionContent2Detail.setText(Constants.courses[i][j].description_2)

        binding.tvTitleContent3Detail.setText(Constants.courses[i][j].title_3)
        binding.tvDescriptionContent3Detail.setText(Constants.courses[i][j].description_3)

        binding.tvTitleContent4Detail.setText(Constants.courses[i][j].title_4)
        binding.tvDescriptionContent4Detail.setText(Constants.courses[i][j].description_4)

        binding.textView5.setText(Constants.courses[i][j].title)

        binding.ivArrow1.setOnClickListener {
            Log.d("test", "test")
            if (detailCourseViewModel.stateDetailCourse.value[0] == 0)
                detailCourseViewModel.loadState(0, 1)
            else
                detailCourseViewModel.loadState(0, 0)
        }

        binding.ivArrow2.setOnClickListener {
            if (detailCourseViewModel.stateDetailCourse.value[1] == 0)
                detailCourseViewModel.loadState(1, 1)
            else
                detailCourseViewModel.loadState(1, 0)
        }

        binding.ivArrow3.setOnClickListener {
            if (detailCourseViewModel.stateDetailCourse.value[2] == 0)
                detailCourseViewModel.loadState(2, 1)
            else
                detailCourseViewModel.loadState(2, 0)
        }

        binding.ivArrow4.setOnClickListener {
            if (detailCourseViewModel.stateDetailCourse.value[3] == 0)
                detailCourseViewModel.loadState(3, 1)
            else
                detailCourseViewModel.loadState(3, 0)
        }
        binding.btnBack.setOnClickListener {
            mainViewModel.loadState(Screens.DETAIL)
        }
        return binding.root
    }
}