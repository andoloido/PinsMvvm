package com.example.pinsmvvm.ui

import androidx.navigation.fragment.findNavController
import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.app.utils.SpUtil
import com.example.pinsmvvm.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun getViewModel(): BaseViewModel = BaseViewModel()

    override fun getLayoutRes(): Int = R.layout.fragment_main

    override fun initView() {
        jumpToDoctorListBt.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_doctorListFragment)
        }
        jumpToOrderListBt.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_orderListFragment)
        }
        jumpToPageOrderBt.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_pageOrderFragment)
        }
        jumpToMediatorOrderBt.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_mediatorOrderFragment)
        }
        logoutBt.setOnClickListener {
            SpUtil.clear()
            findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
        }
    }


}