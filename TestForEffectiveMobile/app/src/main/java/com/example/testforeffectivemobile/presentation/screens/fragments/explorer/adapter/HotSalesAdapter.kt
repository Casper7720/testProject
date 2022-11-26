package com.example.testforeffectivemobile.presentation.screens.fragments.explorer.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testforeffectivemobile.data.model.HomeStore
import com.example.testforeffectivemobile.data.model.HotSales
import com.example.testforeffectivemobile.presentation.screens.fragments.explorer.diff_util.HotSalesDU
import com.example.testforeffectivemobile.presentation.screens.fragments.explorer.view_holder.HotSalesVH

class HotSalesAdapter: ListAdapter<HomeStore, HotSalesVH>(HotSalesDU()) {

    private var list: List<HomeStore> = ArrayList()

    fun setData(list: List<HomeStore>) {
        this.list = list
        submitList(this.list)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesVH {
        return HotSalesVH.create(parent)
    }

    override fun onBindViewHolder(holder: HotSalesVH, position: Int) {
        return holder.bind(list[position])
    }
}