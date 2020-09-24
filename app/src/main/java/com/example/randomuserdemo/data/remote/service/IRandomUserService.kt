package com.example.randomuserdemo.data.remote.service

import arrow.core.Either
import com.example.randomuserdemo.data.remote.model.User

interface IRandomUserService {
    suspend fun getRandomUsers(quantity: Int): Either<Error, List<User>>
}