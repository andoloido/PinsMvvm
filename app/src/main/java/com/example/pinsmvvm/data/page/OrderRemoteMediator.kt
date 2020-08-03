package com.example.pinsmvvm.data.page

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.pinsmvvm.data.db.OrderDatabase
import com.example.pinsmvvm.data.model.OrderBean
import com.example.pinsmvvm.data.network.OrderService

@ExperimentalPagingApi
class OrderRemoteMediator(
    private val service: OrderService,
    private val orderDatabase: OrderDatabase,
    private val queryInfo: HashMap<String, Any?>
) : RemoteMediator<Int, OrderBean>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, OrderBean>
    ): MediatorResult {
        val key = when (loadType) {
            LoadType.REFRESH -> null
            LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
            LoadType.APPEND -> {
                state.lastItemOrNull()?.createdate
            }
        }
        queryInfo["createdate"] = key

        return try {
            val orderBeanList = service.getAllList(queryInfo).data

            val endOfPaginationReached = orderBeanList.isEmpty()
            orderDatabase.withTransaction {
                // clear all tables in the database
                if (loadType == LoadType.REFRESH) {
                    orderDatabase.ordersDao().clear()
                }
                orderDatabase.ordersDao().insertAll(orderBeanList)
            }
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}