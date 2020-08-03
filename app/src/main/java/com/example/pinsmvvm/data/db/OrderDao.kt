package com.example.pinsmvvm.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pinsmvvm.data.model.OrderBean

@Dao
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(orderList: List<OrderBean>)

    @Query("SELECT * FROM orders ORDER BY createdate DESC")
    fun getOrderList(): PagingSource<Int, OrderBean>

    @Query("DELETE FROM orders")
    suspend fun clear()
}