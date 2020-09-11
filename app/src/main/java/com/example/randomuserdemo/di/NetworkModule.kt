package com.example.randomuserdemo.di

import com.example.randomuserdemo.di.provider.RandomUserProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkModule = module {
    single { RandomUserProvider.provideOkHttpClient() }
    single { RandomUserProvider.provideRetrofit(get()) }
    single { RandomUserProvider.provideRandomUserApi(get()) }
    single { RandomUserProvider.provideNetworkService(androidContext()) }
}