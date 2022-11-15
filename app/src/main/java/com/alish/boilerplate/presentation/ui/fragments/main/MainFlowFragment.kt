package com.alish.boilerplate.presentation.ui.fragments.main

import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.alish.boilerplate.R
import com.alish.boilerplate.presentation.base.BaseFlowFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFlowFragment : BaseFlowFragment(
    R.layout.flow_fragment_main, R.id.nav_host_fragment_main
) {

    override fun setupNavigation(navController: NavController) {
        val bottomNavigation = requireView().findViewById<BottomNavigationView>(
            R.id.bottom_navigation
        )

        bottomNavigation.setupWithNavController(navController)
    }
}