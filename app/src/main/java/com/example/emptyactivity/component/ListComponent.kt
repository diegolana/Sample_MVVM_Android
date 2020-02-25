package com.example.emptyactivity.component

import android.content.Context
import android.util.AttributeSet
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.emptyactivity.model.ListItemModel


class ListComponent @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : RecyclerView(context, attrs, defStyleAttr) {

    fun setLifecycleOwner(lifecycleOwner : LifecycleOwner) {
        //TODO
    }

    fun setList(list : ArrayList<ListItemModel>) {
        //TODO
    }
}