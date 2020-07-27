package com.example.pinsmvvm.app.utils

import android.annotation.SuppressLint
import android.provider.Settings.Secure
import com.example.pinsmvvm.App.Companion.application
import com.example.pinsmvvm.app.config.Setting
import java.util.*

object SystemUtil {

    fun getDeviceId(): String {
        var id: String? = Setting.deviceId
        if (id.isNullOrEmpty()) {
            id = getAndroidId()
            if (id.isNullOrEmpty()) {
                id = UUID.randomUUID().toString()
            }
        }
        Setting.deviceId = id
        return id
    }

    @SuppressLint("HardwareIds")
    fun getAndroidId(): String? = Secure.getString(application.contentResolver, Secure.ANDROID_ID)

}