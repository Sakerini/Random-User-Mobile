package com.example.randomuserdemo.data.remote.model

import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("title")
    val title: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
)