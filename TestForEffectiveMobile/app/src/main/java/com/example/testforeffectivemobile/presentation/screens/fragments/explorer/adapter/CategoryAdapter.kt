package com.example.testforeffectivemobile.presentation.screens.fragments.explorer.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testforeffectivemobile.data.model.Category
import com.example.testforeffectivemobile.presentation.screens.fragments.explorer.diff_util.CategoryDU
import com.example.testforeffectivemobile.presentation.screens.fragments.explorer.view_holder.CategoryVH


class CategoryAdapter: ListAdapter<Category, CategoryVH>(CategoryDU()) {

    private var list: List<Category> = ArrayList()
    private var listener: CategoryVH.CategoryListener? = null

    fun setData(list: List<Category>) {
        this.list = list
        submitList(this.list)
    }

    fun setListener(listener: CategoryVH.CategoryListener){
        this.listener = listener
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        return CategoryVH.create(parent)
    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        return holder.bind(list[position], listener)
    }
}