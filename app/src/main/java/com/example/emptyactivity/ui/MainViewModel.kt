package com.example.emptyactivity.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.emptyactivity.model.MyModel
import com.example.emptyactivity.operation.OperationInterface
import com.example.emptyactivity.operation.OperationMock
import com.example.emptyactivity.operation.OperationVolley
import java.lang.Exception

class MainViewModel(application: Application) : BaseViewModel(application) {

    val myModel = MutableLiveData<MyModel>(MyModel())

    var requestException = MutableLiveData<Exception?>(null)

    private var operation:OperationInterface? = null

    private val REQUEST_URL = "https://www.google.com"

    val IMAGE_URL = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png"

    private val operationListener = object : OperationInterface.Listener {
        override fun onResponseSuccess(response: String) {
            myModel.postValue(MyModel(response, 1))
            removeLoading()
        }
        override fun onResponseFail(exception: Exception) {
            requestException.postValue(exception)
            myModel.postValue(MyModel("----", 0))
            removeLoading()
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
        addLoading()
        operation?.request(REQUEST_URL, operationListener)
    }

}
