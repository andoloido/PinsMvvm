package com.example.pinsmvvm.ui.list.order

import android.content.Context
import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.pinsmvvm.R
import com.example.pinsmvvm.data.model.OrderBean
import com.example.pinsmvvm.databinding.ItemOrderBinding

class OrderAdapter(private val mContext: Context) :
    BaseQuickAdapter<OrderBean, BaseViewHolder>(R.layout.item_order) {

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemOrderBinding>(viewHolder.itemView)
    }

    override fun convert(holder: BaseViewHolder, item: OrderBean) {
        val binding = DataBindingUtil.getBinding<ItemOrderBinding>(holder.itemView)
        binding?.item = item
    }
}