package com.example.randomuserdemo.di

import com.example.randomuserdemo.data.service.IRandomUserService
import com.example.randomuserdemo.data.service.RandomUserService
import com.example.randomuserdemo.domen.repository.RandomUserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IRandomUserService> {
        RandomUserService(get())
    }
    single { RandomUserRepository(get()) }
}