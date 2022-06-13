package com.example.okuzminykh.assignmentfirstweek.di

import com.example.okuzminykh.assignmentfirstweek.data.repository.*
import org.koin.dsl.module

val repositoryModule = module {
    single { PreferenceStorage(get()) }
}