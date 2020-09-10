package com.example.pinsmvvm.data.model

data class AddressBean(
    var id: Long, val patient_id: String, val name: String, val telephone: String,
    val province: String, val city: String, val county: String, val address: String)