package com.example.pinsmvvm.data.repo

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pinsmvvm.app.network.orderService
import com.example.pinsmvvm.data.db.OrderDao
import com.example.pinsmvvm.data.db.OrderDatabase
import com.example.pinsmvvm.data.model.OrderBean
import com.example.pinsmvvm.data.network.OrderService
import com.example.pinsmvvm.data.page.OrderPagingSource
import com.example.pinsmvvm.data.page.OrderRemoteMediator
import kotlinx.coroutines.flow.Flow

class OrderMediatorRepo(
    private val orderService: OrderService,
    private val orderDatabase: OrderDatabase
) {
    companion object {
        @Volatile
        private var instance: OrderMediatorRepo? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: OrderMediatorRepo(
                    orderService,
                    OrderDatabase.getInstance()
                ).also { instance = it }
            }
    }

    @ExperimentalPagingApi
    fun getOrderList(
        patientId: String
    ): Flow<PagingData<OrderBean>> {
        val map = hashMapOf<String, Any?>()
        map["patient_id"] = patientId
        map["type"] = 0
        map["size"] = 10
        map["module"] = 501
        return Pager(config = PagingConfig(
            pageSize = 10,
            enablePlaceholders = false,
            initialLoadSize = 20,
            prefetchDistance = 10
        ), remoteMediator = OrderRemoteMediator(orderService, orderDatabase, map),
            pagingSourceFactory = { orderDatabase.ordersDao().getOrderList()}).flow
    }
}