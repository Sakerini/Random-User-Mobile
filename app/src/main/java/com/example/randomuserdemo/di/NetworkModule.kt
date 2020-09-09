package com.example.randomuserdemo.di

import com.example.randomuserdemo.data.api.IRandomUserService
import com.example.randomuserdemo.data.api.RandomUserApi
import com.example.randomuserdemo.di.provider.RandomUserProvider
import okhttp3.OkHttpClient
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { RandomUserProvider.provideOkHttpClient() }
    single { RandomUserProvider.provideRetrofit(get(), BuildConfig.BASE_URL) }
    single { RandomUserProvider.provideRandomUserApi(get()) }
    single { RandomUserProvider.provideNetworkService(androidContext()) }
}