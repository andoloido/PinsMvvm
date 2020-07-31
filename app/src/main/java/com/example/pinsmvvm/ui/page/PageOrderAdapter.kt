package com.example.pinsmvvm.ui.page

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pinsmvvm.R
import com.example.pinsmvvm.data.model.OrderBean
import com.example.pinsmvvm.databinding.ItemOrderBinding

class PageOrderAdapter :
    PagingDataAdapter<OrderBean, RecyclerView.ViewHolder>(ORDER_BEAN_COMPARATOR) {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = DataBindingUtil.bind<ItemOrderBinding>(holder.itemView)
        binding?.item = getItem(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)
        return PageOrderViewHolder(view)
    }

    companion object {
        private val ORDER_BEAN_COMPARATOR = object : DiffUtil.ItemCallback<OrderBean>() {
            override fun areItemsTheSame(oldItem: OrderBean, newItem: OrderBean): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: OrderBean, newItem: OrderBean): Boolean =
                oldItem == newItem
        }
    }
}

class PageOrderViewHolder(view: View) : RecyclerView.ViewHolder(view) {}