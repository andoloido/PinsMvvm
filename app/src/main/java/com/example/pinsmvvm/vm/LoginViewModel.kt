package com.example.pinsmvvm.vm

import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pinsmvvm.app.network.HttpResponse
import com.example.pinsmvvm.app.network.apiService
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val name = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val loginResult = MutableLiveData<Boolean>()
    fun login() {
        viewModelScope.launch {
            runCatching {
                apiService.login3(mapOf("username" to "18525377701", "vcode" to "123456"))
            }.onSuccess {
                loginResult.value = true
            }.onFailure {
                loginResult.value = false
            }
        }
    }
}