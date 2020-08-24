package com.example.pinsmvvm.ui.list

import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.app.utils.findNavController
import com.example.pinsmvvm.app.utils.actionNav
import com.example.pinsmvvm.databinding.FragmentListTestBinding

class ListTestFragment : BaseFragment<FragmentListTestBinding>() {

    override fun getViewModel(): BaseViewModel = BaseViewModel()

    override fun getLayoutRes(): Int = R.layout.fragment_list_test

    override fun initView() {
        mBinding.jumpToDoctorListBt.setOnClickListener {
            findNavController().actionNav(R.id.action_mainFragment_to_doctorListFragment)
        }
        mBinding.jumpToOrderListBt.setOnClickListener {
            findNavController().actionNav(R.id.action_mainFragment_to_orderListFragment)
        }
        mBinding.jumpToPageOrderBt.setOnClickListener {
            findNavController().actionNav(R.id.action_mainFragment_to_pageOrderFragment)
        }
        mBinding.jumpToMediatorOrderBt.setOnClickListener {
            findNavController().actionNav(R.id.action_mainFragment_to_mediatorOrderFragment)
        }
    }
}