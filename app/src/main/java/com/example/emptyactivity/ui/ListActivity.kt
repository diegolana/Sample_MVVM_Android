package com.example.emptyactivity.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.emptyactivity.R
import com.example.emptyactivity.databinding.ListViewDataBinding

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        val binding: ListViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
    }

    fun goBack(v : View) {
        onBackPressed()
    }

}