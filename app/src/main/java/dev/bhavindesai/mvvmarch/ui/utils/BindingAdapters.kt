package dev.bhavindesai.mvvmarch.ui.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.CircleCropTransformation
import dev.bhavindesai.mvvmarch.R

@BindingAdapter("app:imageUri")
fun setImageURI(imageView: ImageView, imageURI: String)  = imageView.load(imageURI) {
    crossfade(true)
    placeholder(R.drawable.ic_launcher_foreground)
    transformations(CircleCropTransformation())
}
