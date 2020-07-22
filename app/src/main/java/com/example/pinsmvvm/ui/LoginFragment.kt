package com.example.pinsmvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.utils.toast
import com.example.pinsmvvm.databinding.FragmentLoginBinding
import com.example.pinsmvvm.vm.LoginViewModel

class LoginFragment : Fragment() {
    private val mViewModel by viewModels<LoginViewModel>()
    private lateinit var mBinding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )
        mBinding.lifecycleOwner = this
        mBinding.loginVM = mViewModel
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.name.observe(viewLifecycleOwner) {
            toast("${mViewModel.name.value} + ${mViewModel.password.value}")
        }
        mViewModel.loginResult.observe(viewLifecycleOwner) {
            toast(it.toString())
        }
    }
}