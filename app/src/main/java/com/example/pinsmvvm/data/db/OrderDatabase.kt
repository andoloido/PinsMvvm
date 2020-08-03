package com.example.pinsmvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pinsmvvm.App.Companion.application
import com.example.pinsmvvm.data.model.OrderBean

@Database(
    entities = [OrderBean::class],
    version = 1,
    exportSchema = false
)
abstract class OrderDatabase : RoomDatabase() {
    abstract fun ordersDao(): OrderDao

    companion object {

        @Volatile
        private var INSTANCE: OrderDatabase? = null

        fun getInstance(): OrderDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase().also { INSTANCE = it }
            }

        private fun buildDatabase() =
            Room.databaseBuilder(
                application.applicationContext,
                OrderDatabase::class.java, "PinsMvvm.db"
            )
                .build()
    }
}