package com.example.pinsmvvm.app.network

import com.example.pinsmvvm.data.model.LoginRes
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("api2/user/login/3")
    suspend fun login3(@Body map: Map<String, String>): HttpResponse<LoginRes>
}