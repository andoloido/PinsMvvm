package com.example.pinsmvvm.vm

import androidx.lifecycle.LiveData
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.data.model.OrderBean
import com.example.pinsmvvm.data.repo.OrderRepo

class OrderListViewModel : BaseViewModel() {
    private val orderRepo = OrderRepo.getInstance()

    fun getOrderList(patientId: String, createDate: Long? = null): LiveData<List<OrderBean>> =
        request { orderRepo.getOrderList(patientId, createDate) }
}