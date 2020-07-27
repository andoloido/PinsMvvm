package com.example.pinsmvvm.app.base

import android.util.Base64

object Constant {

    object Account {
        const val AUTHORIZATION = "AUTHORIZATION"
        const val LOGIN_NAME = "LOGIN_NAME"
        const val USER_ID = "USER_ID"
        const val DEVICE_ID = "DEVICE_ID"
    }

    object HttpConstants {

        val ENCRYPT_KEY =
            Base64.decode("YWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4".toByteArray(), Base64.DEFAULT)

        val ENCRYPT_KEY_IV = byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8)

        const val SAFE_CODE = "F67143D42F4A47266A9D0807EF988752"

        const val CODE_SOURCE_ANDROID = 3

        const val REMOTECTRL_SERVER_URL = "/api/PinsTele/APIs"
    }
}