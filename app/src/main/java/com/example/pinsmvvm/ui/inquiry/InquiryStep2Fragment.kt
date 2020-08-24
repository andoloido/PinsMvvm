package com.example.pinsmvvm.ui.inquiry

import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.databinding.FragmentInquiryStep2Binding

class InquiryStep2Fragment : BaseFragment<FragmentInquiryStep2Binding>() {
    override fun getViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_inquiry_step_2
    }

    override fun initView() {
        mBinding.toolbar.run {
            leftImg.setOnClickListener {
                mActivity.onBackPressed()
            }
            titleTv.text = "this is title"
        }
    }
}