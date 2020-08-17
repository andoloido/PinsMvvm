package com.example.pinsmvvm.ui.inquiry

import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.databinding.FragmentInquiryStep1Binding

class InquiryStep1Fragment : BaseFragment<FragmentInquiryStep1Binding>() {
    override fun getViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_inquiry_step_1
    }

    override fun initView() {

    }
}