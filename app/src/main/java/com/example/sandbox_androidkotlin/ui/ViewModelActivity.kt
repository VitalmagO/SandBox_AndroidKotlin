package com.example.sandbox_androidkotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sandbox_androidkotlin.R
import com.example.sandbox_androidkotlin.data.ProfileViewModel
import com.example.sandbox_androidkotlin.databinding.ViewmodelProfileBinding

class ViewModelActivity : AppCompatActivity() {

    private val viewModel = ProfileViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ViewmodelProfileBinding  = DataBindingUtil.setContentView(
            this, R.layout.viewmodel_profile)

        binding.viewmodel = viewModel

        binding.lifecycleOwner = this
    }
}