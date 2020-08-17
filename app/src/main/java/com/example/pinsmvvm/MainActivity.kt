package com.example.pinsmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.pinsmvvm.app.utils.toast
import com.example.pinsmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private var mExitTime = 0L
    override fun onBackPressed() {
        Navigation.findNavController(this, R.id.nav).currentDestination?.let {
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
                else -> Navigation.findNavController(this, R.id.nav).navigateUp()
            }
        }
    }
}