package com.example.onlinecoursesapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.onlinecoursesapp.R
import com.example.onlinecoursesapp.ui.detail_course.DetailCourseFragment
import com.example.onlinecoursesapp.ui.detail_screen.DetailScreenFragment
import com.example.onlinecoursesapp.ui.home_screen.HomeScreenFragment
import com.example.onlinecoursesapp.ui.login_screen.LoginScreenFragment
import com.example.onlinecoursesapp.ui.onboarding.OnboardingFragment
import com.example.onlinecoursesapp.util.Screens
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            mainViewModel.stateMain.collect {
                when(it) {
                    Screens.LOGIN -> replaceFragment(LoginScreenFragment())
                    Screens.ONBOARDING -> replaceFragment(OnboardingFragment())
                    Screens.HOME -> replaceFragment(HomeScreenFragment())
                    Screens.DETAIL -> replaceFragment(DetailScreenFragment())
                    Screens.DETAIL_COURSE -> replaceFragment(DetailCourseFragment())
                }
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}