package com.example.pinsmvvm.data.page

import androidx.paging.PagingSource
import com.example.pinsmvvm.data.model.OrderBean
import com.example.pinsmvvm.data.network.OrderService

class OrderPagingSource(
    private val service: OrderService,
    private val queryInfo: HashMap<String, Any?>
) :
    PagingSource<Long, OrderBean>() {
    override suspend fun load(params: LoadParams<Long>): LoadResult<Long, OrderBean> {
        return try {
            val key = params.key
            queryInfo["createdate"] = key
            val orderBeanList = service.getAllList(queryInfo).data


            LoadResult.Page(
                data = orderBeanList,
                prevKey = null,
                nextKey = orderBeanList.lastOrNull()?.createdate
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}