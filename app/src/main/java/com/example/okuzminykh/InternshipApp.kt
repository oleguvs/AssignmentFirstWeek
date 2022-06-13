package com.example.okuzminykh.assignmentfirstweek

import android.app.Application
import com.example.okuzminykh.assignmentfirstweek.di.mapperModule
import com.example.okuzminykh.assignmentfirstweek.di.providerModule
import com.example.okuzminykh.assignmentfirstweek.di.repositoryModule
import com.example.okuzminykh.assignmentfirstweek.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class InternshipApp : Application() {

    private val appModules by lazy {
        listOf(mapperModule, repositoryModule, providerModule, viewModelModule)
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@InternshipApp)
            modules(appModules)
        }
    }

}