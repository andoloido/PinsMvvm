package com.example.pinsmvvm.data.repo

import com.example.pinsmvvm.app.config.Setting
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

    suspend fun getAddressList(): HttpResponse<List<AddressBean>> {
        val map = hashMapOf<String, Any>()
        map["patient_id"] = Setting.userId
        return addressService.getAddressList(map)
    }
}