package com.example.randomuserdemo.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.randomuserdemo.R
import com.example.randomuserdemo.presentation.viewmodel.RandomUserGenerationViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val randomUserViewModel: RandomUserGenerationViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        randomUserViewModel.testApi()
    }
}