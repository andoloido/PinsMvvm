package com.example.pinsmvvm.ui.login

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.app.config.Setting
import com.example.pinsmvvm.app.utils.toast
import com.example.pinsmvvm.databinding.FragmentLoginBinding
import com.example.pinsmvvm.vm.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    private val mViewModel by viewModels<LoginViewModel>()

    override fun getViewModel(): BaseViewModel = mViewModel

    override fun getLayoutRes(): Int = R.layout.fragment_login

    override fun initView() {
        if (Setting.authorization.isNotEmpty()) {
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        }
        loginBt.setOnClickListener {
            if (mViewModel.name.get().isNullOrEmpty()) {
                toast(getString(R.string.name_null_alert))
                return@setOnClickListener
            }
            mViewModel.login().observe(this, Observer {
                toast(getString(R.string.login_success))
                Setting.authorization = "PINSV1" + it.token
                Setting.loginName = it.user_telephone
                Setting.userId = it.user_id
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
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