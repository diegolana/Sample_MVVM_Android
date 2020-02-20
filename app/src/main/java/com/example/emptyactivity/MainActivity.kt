package com.example.emptyactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.emptyactivity.databinding.MainDataBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //findViewById<TextView>(R.id.txt_hello).text = "Hello world"
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val binding: MainDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.txtHello.text = "Binding text content"
        binding.model = viewModel.myModel.value

    }

}