package com.example.emptyactivity.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.emptyactivity.model.MyModel
import com.example.emptyactivity.operation.OperationInterface
import com.example.emptyactivity.operation.OperationMock
import java.lang.Exception

class MainViewModel : ViewModel() {

    var qtdLoading: MutableLiveData<Int> = MutableLiveData<Int>(0)

    val myModel : MutableLiveData<MyModel> = MutableLiveData<MyModel>(
        MyModel()
    )

    private val operation:OperationInterface = OperationMock()

    private val REQUEST_URL = "www.google.com"

    private val operationListener = object : OperationInterface.Listener {
        override fun onResponseSuccess(response: String) {
            myModel.postValue(MyModel("Updated", 22))
            qtdLoading.postValue( qtdLoading?.value?.let { return@let it - 1 })
        }
        override fun onResponseFail(exception: Exception) {
            myModel.postValue(MyModel("ERROR", 11))
            qtdLoading.postValue( qtdLoading?.value?.let { return@let it - 1 })
        }
    }

    fun requestData() {
        qtdLoading.value = qtdLoading?.value?.let { return@let it + 1 }
        operation.request(REQUEST_URL, operationListener)
    }

}
