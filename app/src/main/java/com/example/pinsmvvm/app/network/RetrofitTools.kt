package com.example.pinsmvvm.app.network

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

val apiService: ApiService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    RetrofitTools.getApi(ApiService::class.java)
}