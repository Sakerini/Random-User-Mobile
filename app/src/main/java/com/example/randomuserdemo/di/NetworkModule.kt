package com.example.randomuserdemo.di


import com.example.randomuserdemo.data.remote.provider.RandomUserProvider
import org.koin.dsl.module

val networkModule = module {
    val provider = RandomUserProvider()
    single { provider.provideOkHttpClient() }
    single { provider.provideRetrofit(get()) }
    single { provider.provideRandomUserApi(get()) }
}