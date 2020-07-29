package com.example.pinsmvvm.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.data.model.InquiryDataBean
import com.example.pinsmvvm.data.model.OtherDoctorListBean
import com.example.pinsmvvm.data.repo.DoctorRepo
import com.example.pinsmvvm.data.repo.LoginRepo

class DoctorListViewModel : BaseViewModel() {
    private val doctorRepo = DoctorRepo.getInstance()

    fun getDoctorList(patientId: String, type: Int): LiveData<OtherDoctorListBean> =
        request { doctorRepo.getDoctorList(patientId, type) }
}