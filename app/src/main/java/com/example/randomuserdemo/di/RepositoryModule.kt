package com.example.randomuserdemo.di

import com.example.randomuserdemo.data.remote.service.IRandomUserService
import com.example.randomuserdemo.data.remote.service.RandomUserService
import com.example.randomuserdemo.domen.repository.RandomUserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IRandomUserService> {
        RandomUserService(get())
    }
    single { RandomUserRepository(get()) }
}