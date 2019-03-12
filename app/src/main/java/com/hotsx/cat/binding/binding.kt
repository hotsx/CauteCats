package com.hotsx.cat.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions


@BindingAdapter("image_url")
fun loadImage(imageView: ImageView, url: String) {
    Glide.with(imageView)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade(300))
        .into(imageView)
}