package com.example.randomuserdemo.data.remote.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: Name,
    @SerializedName("email")
    val email: String
)