package com.example.pinsmvvm.data.repo

import com.example.pinsmvvm.data.network.LoginService
import com.example.pinsmvvm.app.network.loginService

class LoginRepo private constructor(private val loginService: LoginService) {
    companion object {
        @Volatile
        private var instance: LoginRepo? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: LoginRepo(loginService).also { instance = it }
            }
    }

    suspend fun login(name: String, password: String) =
        loginService.login3(mapOf("username" to name, "vcode" to password))
}