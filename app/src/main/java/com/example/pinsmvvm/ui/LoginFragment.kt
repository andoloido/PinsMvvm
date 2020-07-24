package com.example.pinsmvvm.ui

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.app.utils.toast
import com.example.pinsmvvm.databinding.FragmentLoginBinding
import com.example.pinsmvvm.vm.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    private val mViewModel by viewModels<LoginViewModel>()

    override fun getViewModel(): BaseViewModel = mViewModel

    override fun getLayoutRes(): Int = R.layout.fragment_login

    override fun initView() {
        loginBt.setOnClickListener {
            if (mViewModel.name.get() == null) {
                toast("名字不能为空")
                return@setOnClickListener
            }
            mViewModel.login().observe(this, Observer {
                toast(it.user_id)
            })
        }
    }

    override fun initData() {
        mBinding.loginVM = mViewModel
    }

    override fun showLoading() {
        toast("加载中")
    }

    override fun dismissLoading() {
        toast("加载完成")
    }
}