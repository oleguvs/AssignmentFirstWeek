package com.example.okuzminykh.ui.splash

import com.example.okuzminykh.arch.BaseViewModel
import com.example.okuzminykh.arch.lifecycle.SingleLiveEvent
import kotlinx.coroutines.delay

class SplashViewModel : BaseViewModel() {

    val initEvent = SingleLiveEvent<Boolean>()

    init {
        onLoading(true)
        launch {
            delay(5000)
            initEvent.postValue(true)
        }
    }

}