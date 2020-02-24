package com.example.emptyactivity.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.emptyactivity.model.MyModel
import com.example.emptyactivity.operation.OperationInterface
import com.example.emptyactivity.operation.OperationMock
import java.lang.Exception

class MainViewModel : ViewModel() {

    val myModel : MutableLiveData<MyModel> = MutableLiveData<MyModel>(
        MyModel()
    )

    private val operation:OperationInterface = OperationMock()

    private val REQUEST_URL = "www.google.com"

    private val operationListener = object : OperationInterface.Listener {
        override fun onResponseSuccess(response: String) {
            myModel.postValue(MyModel("Updated", 22))
        }
        override fun onResponseFail(exception: Exception) {
            myModel.postValue(MyModel("ERROR", 11))
        }
    }

    fun requestData() {
        operation.request(REQUEST_URL, operationListener)
    }


}
