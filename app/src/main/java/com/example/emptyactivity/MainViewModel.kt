package com.example.emptyactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.emptyactivity.operation.OperationInterface
import com.example.emptyactivity.operation.OperationMock
import java.lang.Exception

class MainViewModel : ViewModel() {

    val myModel : LiveData<MyModel> = MutableLiveData<MyModel>(MyModel())

    private val operation:OperationInterface = OperationMock()

    private val REQUEST_URL = "www.google.com"

    private val operationListener = object : OperationInterface.Listener {
        override fun onResponseSuccess(response: String) {

        }
        override fun onResponseFail(exception: Exception) {

        }
    }

    fun requestData() {
        operation.request(REQUEST_URL, operationListener)
    }


}
