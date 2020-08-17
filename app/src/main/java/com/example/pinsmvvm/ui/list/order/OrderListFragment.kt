package com.example.pinsmvvm.ui.list.order

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.base.BaseFragment
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.app.config.Setting
import com.example.pinsmvvm.app.utils.toast
import com.example.pinsmvvm.data.model.OrderBean
import com.example.pinsmvvm.databinding.LayoutCommonListBinding
import com.example.pinsmvvm.vm.OrderListViewModel

class OrderListFragment : BaseFragment<LayoutCommonListBinding>() {
    private val mViewModel by viewModels<OrderListViewModel>()

    private lateinit var mAdapter: OrderAdapter

    private var mRefresh = true

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun getLayoutRes(): Int {
        return R.layout.layout_common_list
    }

    override fun initView() {
        mAdapter = OrderAdapter(mActivity)
        mBinding.run {
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(mActivity)
            refreshLayout.setOnRefreshListener {
                mRefresh = true
                getOrderList()
            }
            refreshLayout.setOnLoadMoreListener {
                getOrderList()
            }
        }
        mAdapter.setEmptyView(R.layout.view_empty)
    }

    override fun initData() {
        getOrderList()
    }

    private fun getOrderList() {
        var createDate: Long? = null
        if (!mRefresh) createDate = mAdapter.data.last().createdate
        mViewModel.getOrderList(Setting.userId, createDate).observe(this, mObserver)
    }

    private val mObserver = Observer<List<OrderBean>> {
        if (it.isEmpty()) toast("没有更多数据了")
        if (mRefresh) {
            mRefresh = false
            mAdapter.setList(it)
            mBinding.refreshLayout.finishRefresh()
        } else {
            mAdapter.addData(it)
            mBinding.refreshLayout.finishLoadMore()
        }
    }
}