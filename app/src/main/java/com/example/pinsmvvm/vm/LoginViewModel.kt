package com.example.pinsmvvm.vm

import androidx.databinding.ObservableField
import androidx.lifecycle.*
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.data.model.LoginRes
import com.example.pinsmvvm.data.repo.LoginRepo

class LoginViewModel : BaseViewModel() {
    private val loginRepo = LoginRepo.getInstance()

    val name = ObservableField<String>()
    val password = ObservableField<String>()

    fun login(): LiveData<LoginRes> = request { loginRepo.login(name.get()!!, password.get()!!) }
}