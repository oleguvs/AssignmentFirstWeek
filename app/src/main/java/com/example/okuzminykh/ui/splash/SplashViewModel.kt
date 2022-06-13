package com.example.okuzminykh.assignmentfirstweek.ui.splash

import com.example.okuzminykh.assignmentfirstweek.arch.BaseViewModel
import com.example.okuzminykh.assignmentfirstweek.arch.lifecycle.SingleLiveEvent
import kotlinx.coroutines.delay

class SplashViewModel(

) : BaseViewModel() {

    val initEvent = SingleLiveEvent<Boolean>()

    init {
        onLoading(true)
        launch {
            delay(10000)
            initEvent.postValue(true)
        }
    }

}