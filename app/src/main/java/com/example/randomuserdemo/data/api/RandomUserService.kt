package com.example.randomuserdemo.data.api

import arrow.core.Either
import com.example.randomuserdemo.data.model.User
import java.io.IOException

class RandomUserService(private val apiService: RandomUserApi) : IRandomUserService {
    override suspend fun getRandomUsers(quantity: Int): Either<Error, List<User>> {
        try {
            val result = apiService.getRandomUsers(quantity)
            if (!result.isSuccessful) {
                return Either.left(UnknownError("Unknown Error"))
            }
            val baseResponse = result.body() ?: return Either.left(Error("NullData Error"))
            if (baseResponse.error != null) {
                return Either.left(Error(baseResponse.error))
            }
            if (baseResponse.data == null) {
                return Either.left(Error("NullData Error"))
            }
            return Either.right(baseResponse.data)
        } catch (exception: IOException) {
            return Either.left(Error("Unknown message"))
        }
    }
}