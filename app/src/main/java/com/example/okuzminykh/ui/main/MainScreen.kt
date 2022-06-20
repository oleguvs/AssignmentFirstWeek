@file:Suppress("RedundantOverride")

package com.example.okuzminykh.ui.main

import android.content.res.Configuration
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.okuzminykh.R
import com.example.okuzminykh.arch.BaseActivity
import com.example.okuzminykh.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreen : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModel()

    override val navController: NavController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.homeHostNavFragment) as NavHostFragment
        navHostFragment.navController
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun setObservers() {}


}