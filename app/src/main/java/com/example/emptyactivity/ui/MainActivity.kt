package com.example.emptyactivity.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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
        setupErrorObserver(viewModel)
    }

    private fun setupErrorObserver(viewModel : MainViewModel) {
        viewModel.requestException.observe(this, Observer {exception ->
            exception?.let {
                val message : String = it.cause?.message.let { return@let (it  ?: "Unknown error")}
                viewModel.requestException.setValue(null)
                showErrorDialog(message) }
        })
    }

    private fun showErrorDialog(message : String) {
        val builder = AlertDialog.Builder(this)
        builder.setNeutralButton("OK",null)
        builder.setMessage(message).show()
    }

    fun openNextScreen(v : View) {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

}
