package com.example.pinsmvvm.app.network

import android.util.Log
import com.example.pinsmvvm.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OkHttpTools {
    private const val HTTP_CONNECT_TIMEOUT = 10 * 1000L

    val okHttpClient: OkHttpClient = OkHttpClient.Builder().apply {
        connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        readTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        writeTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        protocols(listOf(Protocol.HTTP_1_1))
        if (BuildConfig.DEBUG) {
            addInterceptor(HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Log.e("RetrofitLog", message)
                }
            }).setLevel(HttpLoggingInterceptor.Level.BODY))
        }
    }.build()
}