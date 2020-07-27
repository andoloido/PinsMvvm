package com.example.pinsmvvm.data.repo

import com.example.pinsmvvm.app.network.DoctorService
import com.example.pinsmvvm.app.network.HttpResponse
import com.example.pinsmvvm.app.network.doctorService
import com.example.pinsmvvm.data.model.OtherDoctorListBean

class DoctorRepo(private val doctorService: DoctorService) {
    companion object {
        @Volatile
        private var instance: DoctorRepo? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: DoctorRepo(doctorService).also { instance = it }
            }
    }

    suspend fun getDoctorList(patientId: String, type: Int): HttpResponse<OtherDoctorListBean> {
        val map = hashMapOf<String, Any>()
        map["patient_id"] = patientId
        map["type"] = type
        return doctorService.getOtherDoctorList(map)
    }
}