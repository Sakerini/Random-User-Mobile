package com.example.randomuserdemo.di

import com.example.randomuserdemo.data.repository.RandomUserRepository
import com.example.randomuserdemo.presentation.viewmodel.RandomUserGenerationViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { RandomUserRepository(get()) }
}

val randomUserViewModelModule = module {
    viewModel {
        RandomUserGenerationViewModel(get(), get())
    }
}