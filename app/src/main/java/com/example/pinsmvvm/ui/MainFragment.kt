package com.example.pinsmvvm.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.databinding.FragmentMainBinding
import com.example.pinsmvvm.ui.home.HomeFragment
import com.example.pinsmvvm.ui.list.ListTestFragment
import com.example.pinsmvvm.ui.list.mediator.MediatorOrderFragment
import com.example.pinsmvvm.ui.list.order.OrderListFragment
import com.example.pinsmvvm.ui.list.page.PageOrderFragment
import com.google.android.material.bottomnavigation.LabelVisibilityMode.LABEL_VISIBILITY_LABELED

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun getViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_main
    }

    override fun initView() {
        initViewPager()
        initBottomNavigationView()
    }

    private fun initViewPager() {
        mBinding.mainViewpager.apply {
            this.isUserInputEnabled = false
            this.offscreenPageLimit = mBinding.mainBottom.itemCount

            adapter = object : FragmentStateAdapter(this@MainFragment) {
                override fun getItemCount(): Int {
                    return mBinding.mainBottom.itemCount
                }

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> HomeFragment()
                        1 -> ListTestFragment()
                        2 -> PageOrderFragment()
                        3 -> OrderListFragment()
                        else -> HomeFragment()
                    }
                }
            }
        }
    }

    private fun initBottomNavigationView() {
        mBinding.mainBottom.apply {
            enableAnimation(false)
            labelVisibilityMode = LABEL_VISIBILITY_LABELED
            isItemHorizontalTranslationEnabled = false

            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_home -> mBinding.mainViewpager.setCurrentItem(0, false)
                    R.id.menu_my_doctor -> mBinding.mainViewpager.setCurrentItem(1, false)
                    R.id.menu_health -> mBinding.mainViewpager.setCurrentItem(2, false)
                    R.id.menu_personal_centre -> mBinding.mainViewpager.setCurrentItem(3, false)
                }
                true
            }
        }
    }
}