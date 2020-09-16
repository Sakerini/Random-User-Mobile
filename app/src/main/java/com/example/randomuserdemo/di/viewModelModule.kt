package com.example.randomuserdemo.di

import com.example.randomuserdemo.presentation.viewmodel.RandomUserGenerationViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val randomUserViewModelModule = module {
    viewModel {
        RandomUserGenerationViewModel(get())
    }
}