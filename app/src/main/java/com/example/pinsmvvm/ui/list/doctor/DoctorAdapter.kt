package com.example.pinsmvvm.ui.list.doctor

import android.content.Context
import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.pinsmvvm.R
import com.example.pinsmvvm.data.model.InquiryDataBean
import com.example.pinsmvvm.databinding.ItemDoctorBinding

class DoctorAdapter(private val mContext: Context) :
    BaseQuickAdapter<InquiryDataBean, BaseViewHolder>(R.layout.item_doctor) {

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemDoctorBinding>(viewHolder.itemView)
    }

    override fun convert(holder: BaseViewHolder, item: InquiryDataBean) {
        val binding = DataBindingUtil.getBinding<ItemDoctorBinding>(holder.itemView)
        binding?.inquiryData = item
    }
}