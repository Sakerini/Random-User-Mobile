package com.example.randomuserdemo.data.model

class BaseResponse<T>(
    val data: T?,
    val error: String?
)