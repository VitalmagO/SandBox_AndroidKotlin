package com.example.sandbox_androidkotlin

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.core.graphics.toColor
import androidx.databinding.BindingAdapter
import com.example.sandbox_androidkotlin.data.Popularity

@BindingAdapter("app:hideIfZero")
fun hideIfZero(view: View, number: Int) {
    view.visibility = if (number == 0) View.GONE else View.VISIBLE
}

@BindingAdapter(value = ["app:progressScaled", "android:max"], requireAll = true)
fun setProgress(progressBar: ProgressBar, likes: Int, max: Int) {
    progressBar.progress = (likes * max / 5).coerceAtMost(max)
}

@BindingAdapter("app:setDrawablePopularity")
fun setDrawablePopularity(imageView: ImageView, popularity: Popularity) {
    val context = imageView.context
    when (popularity) {
        Popularity.NORMAL -> {
            imageView.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_person_black_96dp
                )
            )
        }
        Popularity.POPULAR -> {
            imageView.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_whatshot_black_96dp
                )
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                imageView.setColorFilter(context.getColor(R.color.popular))
            }
        }
        Popularity.STAR -> {
            imageView.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_whatshot_black_96dp
                )
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                imageView.setColorFilter(context.getColor(R.color.star))
            }
        }
    }
}

@BindingAdapter("app:setColorPopularity")
fun setColorPopularity(progressBar: ProgressBar, popularity: Popularity) {
    val context = progressBar.context
    when (popularity) {
        Popularity.NORMAL -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            progressBar.progressTintList = ColorStateList.valueOf(context.getColor(R.color.black))
        }
        Popularity.POPULAR -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            progressBar.progressTintList = ColorStateList.valueOf(context.getColor(R.color.popular))
        }
        Popularity.STAR -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            progressBar.progressTintList = ColorStateList.valueOf(context.getColor(R.color.star))
        }
    }
}



