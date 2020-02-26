package com.example.emptyactivity.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import androidx.databinding.BindingAdapter

@BindingAdapter("android:imageGlide")
fun setImageWithGlide(view: ImageView, imageURL: String?) {
    imageURL?.let {
        Glide.with(view.getContext())
            .load(it)
            .into(view)
    }
}