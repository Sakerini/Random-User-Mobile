package com.example.randomuserdemo.domen.repository

import com.example.randomuserdemo.data.service.IRandomUserService

class RandomUserRepository(private val apiService: IRandomUserService) {
    suspend fun getRandomUsers(quantity: Int) = apiService.getRandomUsers(quantity)
}