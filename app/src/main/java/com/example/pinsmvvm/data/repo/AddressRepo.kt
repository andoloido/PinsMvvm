package com.example.pinsmvvm.data.repo

import com.example.pinsmvvm.app.network.HttpResponse
import com.example.pinsmvvm.app.network.addressService
import com.example.pinsmvvm.app.network.orderService
import com.example.pinsmvvm.data.model.AddressBean
import com.example.pinsmvvm.data.model.OrderBean
import com.example.pinsmvvm.data.model.OtherDoctorListBean
import com.example.pinsmvvm.data.network.AddressService
import com.example.pinsmvvm.data.network.DoctorService
import com.example.pinsmvvm.data.network.OrderService

class AddressRepo(private val addressService: AddressService) {
    companion object {
        @Volatile
        private var instance: AddressRepo? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: AddressRepo(addressService).also { instance = it }
            }
    }

    suspend fun getOrderList(
        patientId: String,
        createDate: Long? = null
    ): HttpResponse<List<AddressBean>> {
        val map = hashMapOf<String, Any>()
        map["patient_id"] = patientId
        map["type"] = 0
        map["size"] = 10
        map["module"] = 501
        createDate?.run { map["createdate"] = this }
        return addressService.getAddressList(map)
    }
}