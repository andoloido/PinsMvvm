package com.example.pinsmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.pinsmvvm.app.utils.toast
import com.example.pinsmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    var mExitTime = 0L
    override fun onBackPressed() {
        findNavController(R.id.nav_host).currentDestination?.let {
            fun tryToFinish() {
                if (System.currentTimeMillis() - mExitTime < 3000) {
                    finish()
                } else {
                    mExitTime = System.currentTimeMillis()
                    toast("双击退出应用")
                }
            }
            when (it.id) {
                R.id.loginFragment, R.id.mainFragment -> tryToFinish()
                else -> findNavController(R.id.nav_host).navigateUp()
            }
        }
    }
}