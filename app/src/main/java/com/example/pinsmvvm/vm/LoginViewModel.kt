package com.example.pinsmvvm.vm

import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val name = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val textToObserve = ObservableField<String>()
    fun login() {

    }
}