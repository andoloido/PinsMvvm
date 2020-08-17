package com.example.pinsmvvm.ui.personal

import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.app.utils.SpUtil
import com.example.pinsmvvm.app.utils.findNavController
import com.example.pinsmvvm.app.utils.navigateAction
import com.example.pinsmvvm.databinding.FragmentPersonalCentreBinding

class PersonalCentreFragment : BaseFragment<FragmentPersonalCentreBinding>() {
    override fun getViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_personal_centre
    }

    override fun initView() {
        mBinding.run {
            logoutBt.setOnClickListener {
                SpUtil.clear()
                findNavController().navigateAction(R.id.action_mainFragment_to_loginFragment)
            }
        }
    }
}