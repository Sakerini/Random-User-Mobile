package com.example.randomuserdemo

import android.app.Application
import com.example.randomuserdemo.di.networkModule
import com.example.randomuserdemo.di.randomUserViewModelModule
import com.example.randomuserdemo.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RandomUserApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RandomUserApplication)
            modules(listOf(networkModule, repositoryModule, randomUserViewModelModule))
        }
    }
}