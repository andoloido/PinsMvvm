package com.example.pinsmvvm.app.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.pinsmvvm.App

@BindingAdapter("url")
fun loadImage(imageView: ImageView, url: String?) {
    Glide.with(App.application).load(url)
        .into(imageView)
}