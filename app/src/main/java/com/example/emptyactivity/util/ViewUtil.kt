package com.example.emptyactivity.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import androidx.databinding.BindingAdapter

@BindingAdapter("android:imageGlide")
fun setImageWithGlide(view: ImageView, imageURL: String) {
            Glide.with(view.getContext())
                .load(imageURL)
                .into(view)
}