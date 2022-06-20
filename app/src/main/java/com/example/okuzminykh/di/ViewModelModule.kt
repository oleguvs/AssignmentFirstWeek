package com.example.okuzminykh.di


import com.example.okuzminykh.ui.game.GameViewModel
import com.example.okuzminykh.ui.main.MainViewModel
import com.example.okuzminykh.ui.setting.SettingViewModel
import com.example.okuzminykh.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { SplashViewModel() }
    viewModel { GameViewModel() }
    viewModel { SettingViewModel() }
    viewModel { MainViewModel() }


}