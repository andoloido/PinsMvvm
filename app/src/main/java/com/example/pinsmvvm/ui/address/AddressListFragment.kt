package com.example.pinsmvvm.ui.address

import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.databinding.FragmentAddressListBinding

class AddressListFragment : BaseFragment<FragmentAddressListBinding>() {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_address_list
    }

    override fun initView() {
        mBinding.toolbar.run {
            titleTv.text = "地址列表"
            this.leftImg.setOnClickListener {
                mActivity.onBackPressed()
            }
        }
    }
}