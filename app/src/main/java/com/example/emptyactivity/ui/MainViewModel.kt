package com.example.emptyactivity.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.emptyactivity.model.MyModel
import com.example.emptyactivity.operation.OperationInterface
import com.example.emptyactivity.operation.OperationMock
import com.example.emptyactivity.operation.OperationVolley
import java.lang.Exception

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var qtdLoading: MutableLiveData<Int> = MutableLiveData<Int>(0)

    val myModel : MutableLiveData<MyModel> = MutableLiveData<MyModel>(MyModel())

    private var operation:OperationInterface? = null

    private val REQUEST_URL = "https://www.google.com"

    private val operationListener = object : OperationInterface.Listener {
        override fun onResponseSuccess(response: String) {
            myModel.postValue(MyModel(response, 1))
            qtdLoading.postValue( qtdLoading?.value?.let { return@let it - 1 })
        }
        override fun onResponseFail(exception: Exception) {
            val message : String = exception.message.let { return@let (it  ?: "unknown error")}
            myModel.postValue(MyModel(message, 0))
            qtdLoading.postValue( qtdLoading?.value?.let { return@let it - 1 })
        }
    }

    init {
        setup()
    }

    private fun setup() {
        operation = OperationVolley()
        operation?.prepare(getApplication())
    }

    fun requestData() {
        qtdLoading.value = qtdLoading?.value?.let { return@let it + 1 }
        operation?.request(REQUEST_URL, operationListener)
    }

}
