package com.example.okuzminykh.di

import com.example.okuzminykh.arch.provider.TextResProvider
import org.koin.dsl.module

val providerModule = module {
    single { TextResProvider(get()) }

}