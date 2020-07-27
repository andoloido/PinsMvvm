package com.example.pinsmvvm.ui

import androidx.navigation.fragment.findNavController
import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun getViewModel(): BaseViewModel = BaseViewModel()

    override fun getLayoutRes(): Int = R.layout.fragment_main

    override fun initView() {
        jumpToListBt.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_doctorListFragment)
        }
    }
}