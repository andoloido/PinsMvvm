package com.example.pinsmvvm.ui.inquiry

import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.app.utils.findNavController
import com.example.pinsmvvm.app.utils.navigateAction
import com.example.pinsmvvm.databinding.FragmentInquiryMainBinding

class InquiryMainFragment : BaseFragment<FragmentInquiryMainBinding>() {
    override fun getViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_inquiry_main
    }

    override fun initView() {
        mBinding.videoInquiryBt.setOnClickListener {
            findNavController().navigateAction(R.id.action_mainFragment_to_inquiryStep1Fragment)
        }
    }
}