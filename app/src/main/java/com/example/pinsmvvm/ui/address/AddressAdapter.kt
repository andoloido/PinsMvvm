package com.example.pinsmvvm.ui.address

import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.pinsmvvm.R
import com.example.pinsmvvm.data.model.AddressBean
import com.example.pinsmvvm.databinding.ItemAddressBinding
import com.example.pinsmvvm.databinding.ItemDoctorBinding

class AddressAdapter : BaseQuickAdapter<AddressBean, BaseViewHolder>(R.layout.item_address) {

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemDoctorBinding>(viewHolder.itemView)
    }

    override fun convert(holder: BaseViewHolder, item: AddressBean) {
        val binding = DataBindingUtil.getBinding<ItemAddressBinding>(holder.itemView)
        binding?.item = item
    }
}