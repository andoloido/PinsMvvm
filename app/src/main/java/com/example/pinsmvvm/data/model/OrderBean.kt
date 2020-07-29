package com.example.pinsmvvm.data.model

data class OrderBean(val id: Long, val doctor_name: String?, val doctor_face_url: String?, val hospital_name: String?, val content: String?,
                     val status: Int, val status_name: String?, val createdate: Long, val office: String?, val doctor_id: Long, val price: Double,
                     val package_name: String?, val position: String?, val send_message: Int, val order_id: Long, val module: Int) {
}