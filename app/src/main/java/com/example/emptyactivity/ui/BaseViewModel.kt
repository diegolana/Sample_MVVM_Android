package com.example.emptyactivity.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.emptyactivity.model.ListItemModel

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    var qtdLoading = MutableLiveData<Int>(0)

    fun addLoading() {
        qtdLoading.postValue( qtdLoading?.value?.let { return@let it - 1 })
    }

    fun removeLoading() {
        qtdLoading.postValue( qtdLoading?.value?.let { return@let it + 1 })
    }
}