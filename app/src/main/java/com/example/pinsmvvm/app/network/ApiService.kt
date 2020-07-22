package com.example.pinsmvvm.app.network

import com.example.pinsmvvm.data.LoginRes
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("api2/user/login/3")
    suspend fun login3(
        @Body map: Map<String, String>
    ): HttpResponse<LoginRes>
}