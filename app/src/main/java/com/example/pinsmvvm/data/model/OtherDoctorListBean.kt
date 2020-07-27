package com.example.pinsmvvm.data.model

data class OtherDoctorListBean(val ongoing_inquiry: Boolean, val inquiry_data: List<InquiryDataBean>)

data class InquiryDataBean(
    val position: String,
    val doctor_id: String,
    val sign: Int,
    val name: String,
    val inquiry_price: Int,
    val hospital_name: String,
    val video_price: Int,
    val video_open: Int,
    val face_url: String,
    val inquiry_public: Int,
    val office: String,
    val skill: String,
    val video_public: Int
)
