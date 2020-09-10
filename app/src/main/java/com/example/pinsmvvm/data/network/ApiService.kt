package com.example.pinsmvvm.data.network

import com.example.pinsmvvm.app.network.HttpResponse
import com.example.pinsmvvm.data.model.AddressBean
import com.example.pinsmvvm.data.model.LoginBean
import com.example.pinsmvvm.data.model.OrderBean
import com.example.pinsmvvm.data.model.OtherDoctorListBean
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("api2/user/login/3")
    suspend fun login3(@Body map: Map<String, String>): HttpResponse<LoginBean>
}

interface DoctorService {
    //fuck retrofit https://github.com/square/retrofit/issues/3275
    @JvmSuppressWildcards
    @POST("api2/inquiry/getOtherDoctorList")
    suspend fun getOtherDoctorList(@Body map: Map<String, Any>): HttpResponse<OtherDoctorListBean>
}

interface OrderService {
    @JvmSuppressWildcards
    @POST("api3/order/patient/getAllList")
    suspend fun getAllList(@Body map: Map<String, Any?>): HttpResponse<List<OrderBean>>
}

@JvmSuppressWildcards
interface AddressService {
    @POST("/api3/patient/address/getList")
    suspend fun getAddressList(@Body map: Map<String, Any>): HttpResponse<List<AddressBean>>

    @POST("/api3/patient/address/add")
    suspend fun addAddress(@Body map: Map<String, Any>): HttpResponse<String>

    @POST("/api3/patient/address/delete")
    suspend fun deleteAddress(@Body map: Map<String, Any>): HttpResponse<Any>

    @POST("/api3/patient/address/modify")
    suspend fun modifyAddress(@Body map: Map<String, Any>): HttpResponse<Any>
}
