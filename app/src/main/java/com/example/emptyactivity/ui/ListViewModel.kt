package com.example.emptyactivity.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.emptyactivity.model.ListItemModel

class ListViewModel(application: Application) : BaseViewModel(application) {

    var listItems = MutableLiveData<ArrayList<ListItemModel>>(ArrayList<ListItemModel>())

    fun requestListData() {
        addLoading()
        Thread(Runnable {
            Thread.sleep(1000)
            var newList =  ArrayList<ListItemModel>()

            for (i in 1..50) {
                newList.add(ListItemModel("Item "+i, i))
            }
            listItems.postValue(newList)
            removeLoading()
        }).start()
    }
}