package com.example.pinsmvvm.ui.home

import androidx.fragment.app.Fragment
import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.app.utils.bindViewPager2
import com.example.pinsmvvm.app.utils.init
import com.example.pinsmvvm.databinding.FragmentHomeBinding
import com.example.pinsmvvm.ui.list.mediator.MediatorOrderFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private var mFragmentList: ArrayList<Fragment> = arrayListOf(MediatorOrderFragment(), MediatorOrderFragment(), MediatorOrderFragment(), MediatorOrderFragment(), MediatorOrderFragment())

    private var mTitleList: ArrayList<String> = arrayListOf("全部", "待付款", "进行中", "已完成", "已取消")

    override fun getViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        //初始化viewpager2
        mBinding.run {
            viewPager.init(this@HomeFragment, mFragmentList)
            magicIndicator.bindViewPager2(viewPager, mTitleList)
        }
        mBinding.run {
            magicIndicator.navigator.notifyDataSetChanged()
            viewPager.adapter?.notifyDataSetChanged()
            viewPager.offscreenPageLimit = mFragmentList.size
        }
    }
}