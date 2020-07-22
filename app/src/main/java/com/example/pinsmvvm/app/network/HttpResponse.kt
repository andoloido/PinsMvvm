package com.example.pinsmvvm.app.network

data class HttpResponse<T>(
    val error_code: Int,
    val status_code: Int,
    val success: Boolean,
    val message: String,
    val userid: String,
    val server_time: Long,
    val error_level: Int,
    val data: T
)