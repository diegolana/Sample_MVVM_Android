package com.example.emptyactivity.component

import android.content.Context
import android.util.AttributeSet
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emptyactivity.model.ListItemModel


class ListComponent @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : RecyclerView(context, attrs, defStyleAttr) {

    private var lifecycleOwner: LifecycleOwner? = null

    init {
        layoutManager = LinearLayoutManager(this.context)
    }

    fun setLifecycleOwner(lifecycleOwner : LifecycleOwner) {
        adapter = ComponentListAdapter(lifecycleOwner)
        this.lifecycleOwner = lifecycleOwner
    }

    fun setList(list : LiveData<ArrayList<ListItemModel>>) {
        lifecycleOwner?.let {
            list.observe(it, Observer {
                (adapter as ComponentListAdapter).setList(it)
            })
        }
    }
}