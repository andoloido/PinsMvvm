package com.example.pinsmvvm.vm

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.data.model.OrderBean
import com.example.pinsmvvm.data.repo.OrderPagingRepo
import kotlinx.coroutines.flow.Flow

class OrderPagingViewModel : BaseViewModel() {
    private val orderRepo = OrderPagingRepo.getInstance()

    fun getOrderList(patientId: String): Flow<PagingData<OrderBean>> =
        orderRepo.getOrderList(patientId).cachedIn(viewModelScope)
}