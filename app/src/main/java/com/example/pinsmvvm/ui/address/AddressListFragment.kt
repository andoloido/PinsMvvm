package com.example.pinsmvvm.ui.address

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.databinding.FragmentAddressListBinding
import com.example.pinsmvvm.vm.AddressViewModel

class AddressListFragment : BaseFragment<FragmentAddressListBinding>() {
    private lateinit var mAdapter: AddressAdapter
    private val mAddressViewModel by viewModels<AddressViewModel>()

    override fun getViewModel(): BaseViewModel? {
        return mAddressViewModel
    }

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
        mBinding.run {
            mAdapter = AddressAdapter()
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(mActivity)
        }
        mAddressViewModel.addressList.observe(this, Observer {
            mAdapter.setList(it)
        })
    }

}