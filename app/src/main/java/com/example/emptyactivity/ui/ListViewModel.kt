package com.example.emptyactivity.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.emptyactivity.model.ListItemModel

class ListViewModel(application: Application) : AndroidViewModel(application) {

    var qtdLoading = MutableLiveData<Int>(0)

    var listItems = MutableLiveData<ArrayList<ListItemModel>>(ArrayList<ListItemModel>())

    fun requestListData() {
        qtdLoading.setValue( qtdLoading?.value?.let { return@let it + 1 })
        Thread(Runnable {
            Thread.sleep(1000)
            var newList =  ArrayList<ListItemModel>()

            for (i in 1..50) {
                newList.add(ListItemModel("Item "+i, i))
            }
            listItems.postValue(newList)
            qtdLoading.postValue( qtdLoading?.value?.let { return@let it - 1 })
        }).start()
    }
}