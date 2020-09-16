package com.example.randomuserdemo.data.service

import arrow.core.Either
import com.example.randomuserdemo.data.model.User

interface IRandomUserService {
    suspend fun getRandomUsers(quantity: Int): Either<Error, List<User>>
}