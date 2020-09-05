package com.example.randomuserdemo.data.api

import arrow.core.Either
import com.example.randomuserdemo.data.model.User
import java.io.IOException

class RandomUserService(private val apiService: RandomUserApi) : IRandomUserService {
    override suspend fun getRandomUsers(quantity: Int): Either<Error, List<User>?> {
        try {
            val result = apiService.getRandomUsers(quantity)
            if (!result.isSuccessful) {
                return Either.left(UnknownError("Unknown Error"))
            }
            val baseResponse = result.body() ?: return Either.left(Error("NullPointer Error"))
            if (result.code() != 200) {
                return Either.left(Error("Api Exception"))
            }
            if (result == null) {
                return Either.left(Error("Null Data"))
            }
            return Either.right(result.body())
        } catch (exception: IOException) {
            return Either.left(Error("Caught IOException"))
        }
    }
}