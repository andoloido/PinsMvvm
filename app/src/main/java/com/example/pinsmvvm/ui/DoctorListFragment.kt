package com.example.pinsmvvm.ui

import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.databinding.FragmentDoctorListBinding

class DoctorListFragment : BaseFragment<FragmentDoctorListBinding>() {
    override fun getViewModel(): BaseViewModel = BaseViewModel()

    override fun getLayoutRes(): Int {
        return R.layout.fragment_doctor_list
    }

    override fun initView() {

    }
}