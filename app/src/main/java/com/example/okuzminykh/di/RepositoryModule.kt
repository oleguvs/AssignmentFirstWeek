package com.example.okuzminykh.di

import com.example.okuzminykh.data.repository.*
import org.koin.dsl.module

val repositoryModule = module {
    single { PreferenceStorage(get()) }
}