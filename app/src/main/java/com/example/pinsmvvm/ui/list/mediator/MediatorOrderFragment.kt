package com.example.pinsmvvm.ui.list.mediator

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.app.config.Setting
import com.example.pinsmvvm.app.utils.toast
import com.example.pinsmvvm.databinding.LayoutCommonListBinding
import com.example.pinsmvvm.vm.OrderMediatorViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MediatorOrderFragment : BaseFragment<LayoutCommonListBinding>() {
    private val mViewModel by viewModels<OrderMediatorViewModel>()

    private lateinit var mAdapter: MediatorOrderAdapter

    private var noMoreData = false

    private var isLoading = false

    private var isRefreshing = false
    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun getLayoutRes(): Int {
        return R.layout.layout_common_list
    }

    override fun initView() {
        mAdapter = MediatorOrderAdapter()
        mBinding.run {
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(mActivity)
            refreshLayout.setOnRefreshListener {
                isRefreshing = true
                mAdapter.refresh()
            }
            refreshLayout.setOnLoadMoreListener {
                isLoading = true
                if (noMoreData) {
                    toast("no more data")
                    refreshLayout.finishLoadMore()
                }
            }
        }
    }

    @ExperimentalPagingApi
    override fun initData() {
        lifecycleScope.launch {
            mViewModel.getOrderList(Setting.userId).collectLatest {
                mAdapter.submitData(it)
            }
        }
        mAdapter.addLoadStateListener { loadState ->
            when (loadState.refresh) {
                is LoadState.NotLoading -> {
                    if (isRefreshing) {
                        mBinding.refreshLayout.finishRefresh()
                        isRefreshing = false
                    }
                }
            }
            when (loadState.append) {
                is LoadState.Loading -> {
                    isLoading = true
                }
                is LoadState.NotLoading -> {
                    if (loadState.append.endOfPaginationReached) {
                        noMoreData = true
                    }
                    if (isLoading) {
                        isLoading = false
                        mBinding.refreshLayout.finishLoadMore()
                    }
                }
                is LoadState.Error -> mBinding.refreshLayout.finishLoadMore()
            }
        }
    }
}