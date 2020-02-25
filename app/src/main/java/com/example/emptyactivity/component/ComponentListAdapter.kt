package com.example.emptyactivity.component

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.emptyactivity.R
import com.example.emptyactivity.databinding.ListCellDataBinding
import com.example.emptyactivity.model.ListItemModel

class ComponentListAdapter(private val lifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<ComponentListViewHolder>() {

    private var listItems : List<ListItemModel> = ArrayList<ListItemModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentListViewHolder {
        var binding: ListCellDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_item_cell, parent, false)
        binding.lifecycleOwner = lifecycleOwner

        return ComponentListViewHolder(binding)
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: ComponentListViewHolder, position: Int) {
        holder.binding.item = listItems[position]
    }

    fun setList(list : List<ListItemModel>) {
        listItems = list
        notifyDataSetChanged()
    }

}
