package com.example.pinsmvvm.ui.page

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.app.config.Setting
import com.example.pinsmvvm.app.utils.toast
import com.example.pinsmvvm.data.model.OrderBean
import com.example.pinsmvvm.databinding.LayoutCommonListBinding
import com.example.pinsmvvm.ui.order.OrderAdapter
import com.example.pinsmvvm.vm.OrderListViewModel
import com.example.pinsmvvm.vm.OrderPagingViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PageOrderFragment : BaseFragment<LayoutCommonListBinding>() {
    private val mViewModel by viewModels<OrderPagingViewModel>()

    private lateinit var mAdapter: PageOrderAdapter

    private var mRefresh = true

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun getLayoutRes(): Int {
        return R.layout.layout_common_list
    }

    override fun initView() {
        mAdapter = PageOrderAdapter()
        mBinding.run {
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(mActivity)
            refreshLayout.setOnRefreshListener {
                mRefresh = true
                mAdapter.refresh()
            }
        }
    }

    override fun initData() {
        lifecycleScope.launch {
            mViewModel.getOrderList(Setting.userId).collectLatest {
                mAdapter.submitData(it)
            }
        }
        mAdapter.addLoadStateListener { loadState ->
            when (loadState.refresh) {
                is LoadState.NotLoading -> {
                    mBinding.refreshLayout.finishRefresh()
                }
            }
            when (loadState.append) {
                is LoadState.Loading -> {
                    mBinding.refreshLayout.autoLoadMore()
                }
                is LoadState.NotLoading -> {
                    mBinding.refreshLayout.finishLoadMore()
                }
            }
        }

    }
}