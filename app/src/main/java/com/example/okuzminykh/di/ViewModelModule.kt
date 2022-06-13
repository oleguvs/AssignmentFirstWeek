package com.example.okuzminykh.assignmentfirstweek.di


import com.example.okuzminykh.assignmentfirstweek.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { SplashViewModel() }


}