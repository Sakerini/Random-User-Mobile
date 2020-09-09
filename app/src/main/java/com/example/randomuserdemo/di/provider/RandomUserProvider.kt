package com.example.randomuserdemo.di.provider

import android.content.Context
import com.example.randomuserdemo.data.api.IRandomUserService
import com.example.randomuserdemo.data.api.RandomUserApi
import com.example.randomuserdemo.presentation.service.NetworkService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomUserProvider {

    companion object {

        fun provideNetworkService(context: Context) = NetworkService(context)

        fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit {
            return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }

        fun provideOkHttpClient(): OkHttpClient {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            return OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .build()
        }

        fun provideRandomUserApi(retrofit: Retrofit): RandomUserApi =
            retrofit.create(RandomUserApi::class.java)

        fun provideRandomUserApiService(randomUserService: IRandomUserService): IRandomUserService =
            randomUserService
    }
}