package com.example.pinsmvvm.ui.doctor

import android.content.Context
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.pinsmvvm.R
import com.example.pinsmvvm.data.model.InquiryDataBean
import com.example.pinsmvvm.databinding.ItemDoctorBinding

class DoctorAdapter(private val mContext: Context) :
    BaseQuickAdapter<InquiryDataBean, BaseViewHolder>(R.layout.item_doctor) {
    init {
        setDiffCallback(DiffCallback())
    }

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemDoctorBinding>(viewHolder.itemView)
    }

    override fun convert(holder: BaseViewHolder, item: InquiryDataBean) {
        val binding = DataBindingUtil.getBinding<ItemDoctorBinding>(holder.itemView)
        binding?.inquiryData = item
    }

    class DiffCallback : DiffUtil.ItemCallback<InquiryDataBean>() {
        override fun areItemsTheSame(
            oldItem: InquiryDataBean,
            newItem: InquiryDataBean
        ): Boolean {
            return oldItem.doctor_id == newItem.doctor_id
        }

        override fun areContentsTheSame(
            oldItem: InquiryDataBean,
            newItem: InquiryDataBean
        ): Boolean {
            return oldItem == newItem
        }
    }
}