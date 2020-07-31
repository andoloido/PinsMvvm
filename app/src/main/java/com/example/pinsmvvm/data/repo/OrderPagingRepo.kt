package com.example.pinsmvvm.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pinsmvvm.app.network.HttpResponse
import com.example.pinsmvvm.app.network.orderService
import com.example.pinsmvvm.data.model.OrderBean
import com.example.pinsmvvm.data.network.OrderService
import com.example.pinsmvvm.data.page.OrderPagingSource
import kotlinx.coroutines.flow.Flow

class OrderPagingRepo(private val orderService: OrderService) {
    companion object {
        @Volatile
        private var instance: OrderPagingRepo? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: OrderPagingRepo(orderService).also { instance = it }
            }
    }

    fun getOrderList(
        patientId: String
    ): Flow<PagingData<OrderBean>> {
        val map = hashMapOf<String, Any?>()
        map["patient_id"] = patientId
        map["type"] = 0
        map["size"] = 10
        map["module"] = 501
        return Pager(config = PagingConfig(pageSize = 10, enablePlaceholders = false, initialLoadSize = 1, prefetchDistance = 1),
            pagingSourceFactory = { OrderPagingSource(orderService, map) }).flow
    }
}