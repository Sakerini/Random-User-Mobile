package com.example.randomuserdemo.di

import android.content.Context
import com.example.randomuserdemo.data.api.IRandomUserService
import com.example.randomuserdemo.data.api.RandomUserApi
import com.example.randomuserdemo.presentation.service.NetworkService
import okhttp3.OkHttpClient
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), BuildConfig.BASE_URL) }
    single { provideRandomUserApi(get()) }
    single { provideNetworkService(androidContext()) }
}

private fun provideNetworkService(context: Context) = NetworkService(context)

private fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}

private fun provideRandomUserApi(retrofit: Retrofit): RandomUserApi = retrofit.create(RandomUserApi::class.java)

private fun provideRandomUserApiService(randomUserService: IRandomUserService): IRandomUserService = randomUserService
