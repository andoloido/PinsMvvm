package com.example.pinsmvvm.app.network

import com.example.pinsmvvm.data.network.DoctorService
import com.example.pinsmvvm.data.network.LoginService
import com.example.pinsmvvm.data.network.OrderService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitTools {
    private val retrofit by lazy { buildRetrofit(RemoteSettingUtils.mainUrl) }

    private fun buildRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder().apply {
            addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            client(OkHttpTools.okHttpClient)
            baseUrl(baseUrl)
        }.build()
    }

    fun <T> getApi(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}

val loginService: LoginService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    RetrofitTools.getApi(LoginService::class.java)
}

val doctorService: DoctorService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    RetrofitTools.getApi(DoctorService::class.java)
}

val orderService: OrderService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    RetrofitTools.getApi(OrderService::class.java)
}