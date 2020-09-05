package com.example.randomuserdemo.data.api

import com.example.randomuserdemo.data.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserApi {
    @GET("api/")
    fun getRandomUsers(@Query("results") quantity: Int): Response<List<User>>
}