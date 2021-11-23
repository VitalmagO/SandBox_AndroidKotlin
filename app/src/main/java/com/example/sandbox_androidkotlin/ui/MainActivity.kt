package com.example.sandbox_androidkotlin.ui

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.DataBindingUtil
import com.example.sandbox_androidkotlin.R
import com.example.sandbox_androidkotlin.data.Popularity
import com.example.sandbox_androidkotlin.data.SimpleViewModel
import com.example.sandbox_androidkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Obtain ViewModel from ViewModelProviders
    private val viewModel = SimpleViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        binding.lifecycleOwner = this

        binding.viewmodel = viewModel
    }
}
