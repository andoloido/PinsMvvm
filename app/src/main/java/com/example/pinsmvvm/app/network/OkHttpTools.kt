package com.example.pinsmvvm.app.network

import android.util.Log
import com.example.pinsmvvm.BuildConfig
import com.example.pinsmvvm.app.base.Constant
import com.example.pinsmvvm.app.config.Setting.authorization
import com.example.pinsmvvm.app.config.Setting.deviceId
import com.example.pinsmvvm.app.network.interceptors.HeaderInterceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OkHttpTools {
    private const val HTTP_CONNECT_TIMEOUT = 10 * 1000L

    private val headerInterceptor = object : HeaderInterceptor() {
        override val header: Map<String, String>
            get() {
                val map = hashMapOf<String, String>()
                map["Content-Type"] = "application/json"
                map["pins-source"] = Constant.HttpConstants.CODE_SOURCE_ANDROID.toString()
                map["pins-app-version"] = BuildConfig.VERSION_NAME
                if (deviceId.isNotEmpty()) map["pins-device"] = deviceId
                map["pins-timestamp"] = System.currentTimeMillis().toString()
                if (authorization.isNotEmpty()) map["pins-device"] = authorization
                return map
            }
    }

    val okHttpClient: OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(headerInterceptor)
        connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        readTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        writeTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        protocols(listOf(Protocol.HTTP_1_1))
        if (BuildConfig.DEBUG) {
            addInterceptor(HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Log.i("RetrofitLog", message)
                }
            }).setLevel(HttpLoggingInterceptor.Level.BODY))
        }
    }.build()


}