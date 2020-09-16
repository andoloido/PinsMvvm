package com.example.pinsmvvm.vm

import androidx.lifecycle.*
import com.example.pinsmvvm.app.base.BaseViewModel
import com.example.pinsmvvm.data.model.AddressBean
import com.example.pinsmvvm.data.model.OtherDoctorListBean
import com.example.pinsmvvm.data.repo.AddressRepo
import com.example.pinsmvvm.data.repo.DoctorRepo

class AddressViewModel : BaseViewModel() {
    private val addressRepo = AddressRepo.getInstance()
    val addressList: LiveData<List<AddressBean>> = request { addressRepo.getAddressList() }

}