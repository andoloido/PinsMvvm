package com.example.pinsmvvm.vm

import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.data.model.OrderBean
import com.example.pinsmvvm.data.repo.OrderMediatorRepo
import com.example.pinsmvvm.data.repo.OrderPagingRepo
import kotlinx.coroutines.flow.Flow

class OrderMediatorViewModel : BaseViewModel() {
    private val orderMediatorRepo = OrderMediatorRepo.getInstance()

    @ExperimentalPagingApi
    fun getOrderList(patientId: String): Flow<PagingData<OrderBean>> =
        orderMediatorRepo.getOrderList(patientId).cachedIn(viewModelScope)
}