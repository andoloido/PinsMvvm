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
        mBinding.run {
            doctorListRv.adapter = mAdapter
            doctorListRv.layoutManager = LinearLayoutManager(mActivity)
        }
    }

    override fun initData() {
        mViewModel.getDoctorList(Setting.userId, 0).observe(this, Observer {
            mAdapter.addData(it.inquiry_data)
        })
        mAdapter.setEmptyView(R.layout.view_empty)
    }
}