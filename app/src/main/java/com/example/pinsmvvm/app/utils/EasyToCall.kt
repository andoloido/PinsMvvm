package com.example.pinsmvvm.app.utils

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

/**
 * 不定义LONG的Toast是因为short就够了
 */
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(message: String) {
    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.findNavController(): NavController {
    return NavHostFragment.findNavController(this)
}

var previousClickTimeMillis = 0L
const val NAV_DELAY_MILLIS = 500L
/**
 * avoid invoke navigate several times during a short time
 */
fun NavController.actionNav(action: Int, bundle: Bundle? = null) {
    val currentTimeMillis = System.currentTimeMillis()
    if (currentTimeMillis >= previousClickTimeMillis + NAV_DELAY_MILLIS) {
        previousClickTimeMillis = currentTimeMillis
        navigate(action, bundle)
    }
}