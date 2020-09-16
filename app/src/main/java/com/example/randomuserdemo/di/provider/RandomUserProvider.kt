package com.example.randomuserdemo.di.provider

import com.example.randomuserdemo.BuildConfig
import com.example.randomuserdemo.data.service.IRandomUserService
import com.example.randomuserdemo.data.api.RandomUserApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomUserProvider() {
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
        return OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    fun provideRandomUserApi(retrofit: Retrofit): RandomUserApi =
        retrofit.create(RandomUserApi::class.java)

    fun provideRandomUserApiService(randomUserService: IRandomUserService): IRandomUserService =
        randomUserService
}