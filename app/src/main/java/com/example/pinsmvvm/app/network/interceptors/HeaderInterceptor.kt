package com.example.pinsmvvm.app.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

/**
 * 用于添加header
 */
abstract class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val headerMap = header
        val set = headerMap.entries
        for ((key, value) in set) {
            builder.removeHeader(key)
            builder.addHeader(key, value)
        }
        val request = builder.build()
        return chain.proceed(request)
    }

    protected abstract val header: Map<String, String>
}