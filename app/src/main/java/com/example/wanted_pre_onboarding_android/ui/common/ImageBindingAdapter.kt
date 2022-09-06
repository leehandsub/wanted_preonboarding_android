package com.example.wanted_pre_onboarding_android.ui.common

import android.widget.ImageView
import com.bumptech.glide.Glide

fun loadImageGlide(view: ImageView, imageUrl: String?) {
    Glide.with(view)
        .load(imageUrl)
        .into(view)
}

