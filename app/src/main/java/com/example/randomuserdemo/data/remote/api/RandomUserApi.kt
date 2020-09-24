package com.example.randomuserdemo.data.remote.api

import com.example.randomuserdemo.data.remote.model.BaseResponse
import com.example.randomuserdemo.data.remote.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserApi {
    @GET("api/")
    suspend fun getRandomUsers(@Query("results") quantity: Int): Response<BaseResponse<List<User>>>
}