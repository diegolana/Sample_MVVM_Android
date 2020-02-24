package com.example.emptyactivity.operation

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class OperationVolley() : OperationInterface {

    var queue : RequestQueue? = null

    override fun prepare(context: Context) {
        queue = Volley.newRequestQueue(context)
    }

    override fun request(url: String, listener: OperationInterface.Listener) {
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                listener.onResponseSuccess(response.substring(0, 500))
            },
            Response.ErrorListener {
                listener.onResponseFail(it)
            })

        // Add the request to the RequestQueue.
        queue?.add(stringRequest)
    }

}
