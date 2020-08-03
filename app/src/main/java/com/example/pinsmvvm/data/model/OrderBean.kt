package com.example.pinsmvvm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "orders")
data class OrderBean(
    @PrimaryKey @field: SerializedName("id") val id: Long,
    @field: SerializedName("doctor_name") val doctor_name: String?,
    @field: SerializedName("doctor_face_url") val doctor_face_url: String?,
    @field: SerializedName("hospital_name") val hospital_name: String?,
    @field: SerializedName("content") val content: String?,
    @field: SerializedName("status") val status: Int,
    @field: SerializedName("status_name") val status_name: String?,
    @field: SerializedName("createdate") val createdate: Long,
    @field: SerializedName("office") val office: String?,
    @field: SerializedName("doctor_id") val doctor_id: Long,
    @field: SerializedName("price") val price: Double,
    @field: SerializedName("package_name") val package_name: String?,
    @field: SerializedName("position") val position: String?,
    @field: SerializedName("send_message") val send_message: Int,
    @field: SerializedName("order_id") val order_id: Long,
    @field: SerializedName("module") val module: Int
) {
}