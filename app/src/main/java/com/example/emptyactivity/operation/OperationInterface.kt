package com.example.emptyactivity.operation

import java.lang.Exception

interface OperationInterface {
    fun prepare()
    fun request(url:String, listener: Listener)

    interface Listener {
        fun onResponseSuccess(response: String)
        fun onResponseFail(exception: Exception)
    }
}