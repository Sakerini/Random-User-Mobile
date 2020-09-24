package com.example.randomuserdemo.data.remote.model

import com.google.gson.annotations.SerializedName

class BaseResponse<T>(
    @SerializedName("results")
    val results: T? = null,
    @SerializedName("error")
    val error: String? = null
)