package com.example.emptyactivity.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.emptyactivity.R
import com.example.emptyactivity.databinding.MainDataBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val binding: MainDataBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        binding.setLifecycleOwner(this)
        binding.txtHello.text = "Binding text content"
        binding.viewModel = viewModel

    }

}
