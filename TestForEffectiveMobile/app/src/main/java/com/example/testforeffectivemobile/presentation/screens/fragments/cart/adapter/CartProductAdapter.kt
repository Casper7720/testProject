package com.example.testforeffectivemobile.presentation.screens.fragments.cart.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testforeffectivemobile.data.model.Basket
import com.example.testforeffectivemobile.data.model.BestSeller
import com.example.testforeffectivemobile.presentation.screens.fragments.cart.diff_util.BasketDU
import com.example.testforeffectivemobile.presentation.screens.fragments.cart.view_holder.ProductCartVH


class CartProductAdapter: ListAdapter<Basket, ProductCartVH>(BasketDU()) {

    private var list: List<Basket> = ArrayList()
    private var listener: ProductCartVH.ProductCartListener? = null

    fun setData(list: List<Basket>) {
        this.list = list
        submitList(this.list)
    }

    fun setListener(listener: ProductCartVH.ProductCartListener){
        this.listener = listener
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCartVH {
        return ProductCartVH.create(parent)
    }

    override fun onBindViewHolder(holder: ProductCartVH, position: Int) {
        return holder.bind(list[position], listener)
    }
}

