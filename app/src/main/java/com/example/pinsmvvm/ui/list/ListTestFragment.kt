package com.example.pinsmvvm.ui.list

import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.app.utils.SpUtil
import com.example.pinsmvvm.databinding.FragmentListTestBinding
import kotlinx.android.synthetic.main.fragment_list_test.*

class ListTestFragment : BaseFragment<FragmentListTestBinding>() {

    override fun getViewModel(): BaseViewModel = BaseViewModel()

    override fun getLayoutRes(): Int = R.layout.fragment_list_test

    override fun initView() {
        mBinding.jumpToDoctorListBt.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_doctorListFragment)
        }
        mBinding.jumpToOrderListBt.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_orderListFragment)
        }
        mBinding.jumpToPageOrderBt.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_pageOrderFragment)
        }
        mBinding.jumpToMediatorOrderBt.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_mediatorOrderFragment)
        }
    }
}