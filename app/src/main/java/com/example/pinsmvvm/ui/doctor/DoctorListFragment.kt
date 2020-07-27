package com.example.pinsmvvm.ui.doctor

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.app.config.Setting
import com.example.pinsmvvm.databinding.FragmentDoctorListBinding
import com.example.pinsmvvm.vm.DoctorListViewModel

class DoctorListFragment : BaseFragment<FragmentDoctorListBinding>() {
    private val mViewModel by viewModels<DoctorListViewModel>()

    private lateinit var mAdapter: DoctorAdapter

    override fun getViewModel(): BaseViewModel = mViewModel

    override fun getLayoutRes(): Int {
        return R.layout.fragment_doctor_list
    }

    override fun initView() {
        mAdapter = DoctorAdapter(mActivity)
        mBinding.apply {
            doctorListRv.adapter = mAdapter
            doctorListRv.layoutManager = LinearLayoutManager(mActivity)
        }
    }

    override fun initData() {
        mBinding.doctorListVM = mViewModel
        mViewModel.getDoctorList(Setting.userId, 0).observe(this, Observer {
            var list = it.inquiry_data.toMutableList()
            list.addAll(list)
            list.addAll(list)
            list.addAll(list)
            list.addAll(list)
            mAdapter.submitList(list)
        })
    }
}