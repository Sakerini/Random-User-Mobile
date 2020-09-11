package com.example.randomuserdemo.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.randomuserdemo.R
import com.example.randomuserdemo.di.networkModule
import com.example.randomuserdemo.di.randomUserViewModelModule
import com.example.randomuserdemo.di.repositoryModule
import com.example.randomuserdemo.presentation.viewmodel.RandomUserGenerationViewModel
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    private val randomUserViewModel: RandomUserGenerationViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(listOf(networkModule, repositoryModule, randomUserViewModelModule))
        }
        setContentView(R.layout.activity_main)

        randomUserViewModel.testApi()
    }
}