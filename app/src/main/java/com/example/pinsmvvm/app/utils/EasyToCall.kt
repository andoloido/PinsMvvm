package com.example.pinsmvvm.app.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * 不定义LONG的Toast是因为short就够了
 */
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(message: String) {
    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
}