package com.example.emptyactivity.operation

import android.content.Context
import java.lang.Exception
import kotlin.random.Random

class OperationMock() : OperationInterface {

    override fun prepare(context: Context) {
        //TODO("not implemented")
    }

    override fun request(url: String, listener: OperationInterface.Listener) {
        //TODO("partial implemented")

        Thread(Runnable {
            Thread.sleep(1000)
            if (requestFake()) {
                listener.onResponseSuccess("Worked!")
            } else {
                listener.onResponseFail(Exception("Mock Request Fail"))
            }

        }).start()

    }

    private fun requestFake():Boolean {
        return Random.nextBoolean()
    }


}