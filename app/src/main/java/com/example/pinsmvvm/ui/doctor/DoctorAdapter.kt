package com.example.pinsmvvm.ui.doctor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pinsmvvm.R
import com.example.pinsmvvm.data.model.InquiryDataBean
import com.example.pinsmvvm.databinding.ItemDoctorBinding

class DoctorAdapter(private val mContext: Context) :
    ListAdapter<InquiryDataBean, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemDoctorBinding>(
            LayoutInflater.from(mContext),
            R.layout.item_doctor,
            parent,
            false
        )
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = DataBindingUtil.getBinding<ItemDoctorBinding>(holder.itemView)
        binding?.inquiryData = getItem(position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

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