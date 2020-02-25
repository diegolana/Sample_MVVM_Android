package com.example.emptyactivity.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ListViewModel(application: Application) : AndroidViewModel(application) {

    var qtdLoading = MutableLiveData<Int>(0)

    fun requestListData() {

    }
}