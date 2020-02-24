package com.example.emptyactivity.operation

import android.content.Context
import java.lang.Exception

interface OperationInterface {
    fun prepare(context: Context)
    fun request(url:String, listener: Listener)

    interface Listener {
        fun onResponseSuccess(response: String)
        fun onResponseFail(exception: Exception)
    }
}