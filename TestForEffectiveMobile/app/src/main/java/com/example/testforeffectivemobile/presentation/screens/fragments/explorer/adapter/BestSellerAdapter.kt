package com.example.testforeffectivemobile.presentation.screens.fragments.explorer.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testforeffectivemobile.data.model.BestSeller
import com.example.testforeffectivemobile.presentation.screens.fragments.explorer.diff_util.BestSellerDU
import com.example.testforeffectivemobile.presentation.screens.fragments.explorer.view_holder.BestSellerVH

class BestSellerAdapter: ListAdapter<BestSeller, BestSellerVH>(BestSellerDU()) {

    private var list: List<BestSeller> = ArrayList()
    private var listener: BestSellerVH.BestSellerListener? = null

    fun setData(list: List<BestSeller>) {
        this.list = list
        submitList(this.list)
    }

    fun setListener(listener: BestSellerVH.BestSellerListener){
        this.listener = listener
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerVH {
        return BestSellerVH.create(parent)
    }

    override fun onBindViewHolder(holder: BestSellerVH, position: Int) {
        return holder.bind(list[position], listener)
    }
}