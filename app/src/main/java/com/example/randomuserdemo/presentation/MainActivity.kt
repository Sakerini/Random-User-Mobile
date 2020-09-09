package com.example.randomuserdemo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.randomuserdemo.R
import com.example.randomuserdemo.di.networkModule
import com.example.randomuserdemo.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(listOf(networkModule, repositoryModule))
        }
        setContentView(R.layout.activity_main)
    }
}