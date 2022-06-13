package com.example.okuzminykh.assignmentfirstweek.di

import com.example.okuzminykh.assignmentfirstweek.arch.provider.TextResProvider
import org.koin.dsl.module

val providerModule = module {
    single { TextResProvider(get()) }

}