package com.example.pinsmvvm.app.adapter

import android.widget.ImageView
import androidx.constraintlayout.widget.Placeholder
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.pinsmvvm.App
import com.example.pinsmvvm.R

@BindingAdapter(value = ["url", "defaultDrawable"], requireAll = false)
fun loadImage(imageView: ImageView, url: String?, defaultDrawable: Int) {
    Glide.with(App.application).load(url)
        .placeholder(defaultDrawable)
        .into(imageView)
}