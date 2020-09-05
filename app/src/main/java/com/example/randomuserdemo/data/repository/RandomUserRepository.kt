package com.example.randomuserdemo.data.repository

import com.example.randomuserdemo.data.api.IRandomUserService

class RandomUserRepository(private val apiService: IRandomUserService) {
    suspend fun getRandomUsers(quantity: Int) = apiService.getRandomUsers(quantity)
}