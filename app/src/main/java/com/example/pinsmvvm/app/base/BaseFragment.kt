package com.example.pinsmvvm.app.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.pinsmvvm.app.utils.toast

abstract class BaseFragment<DB : ViewDataBinding> : Fragment() {
    lateinit var mActivity: AppCompatActivity

    protected var mRootView: View? = null

    private var mIsHasData = false//是否加载过数据

    lateinit var mBinding: DB

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModelAction()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mRootView == null) {
            mBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
            // 让xml内绑定的LiveData和Observer建立连接，让LiveData能感知Activity的生命周期
            mBinding.lifecycleOwner = this
            mRootView = mBinding.root
        }
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onResume() {
        super.onResume()
        lazyLoadData()

    }

    private fun lazyLoadData() {
        if (!mIsHasData) {
            mIsHasData = true
            initData()
        }
    }

    private fun initViewModelAction() {
        this.getViewModel().let { baseViewModel ->
            baseViewModel.mStateLiveData.observe(this, Observer { stateActionState ->
                when (stateActionState) {
                    RequestState -> showLoading()
                    SuccessState -> dismissLoading()
                    is ErrorState -> {
                        dismissLoading()
                        stateActionState.message?.apply {
                            toast(this)
                        }
                    }
                }
            })
        }
    }

    abstract fun getViewModel(): BaseViewModel

    abstract fun getLayoutRes(): Int

    abstract fun initView()

    open fun initData() {}

    open fun showLoading() {}

    open fun dismissLoading() {}

    open fun handleError() {}
}