package com.example.testforeffectivemobile.presentation.screens.fragments.product.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testforeffectivemobile.R
import com.example.testforeffectivemobile.data.model.CapacityItem
import com.example.testforeffectivemobile.data.model.ColorItem
import com.google.android.material.card.MaterialCardView

class ProductCapacityAdapter : RecyclerView.Adapter<ProductCapacityVH>() {

    private var items: List<CapacityItem> = listOf()
    private var listener: ProductCapacityVH.ProductCapacityListener? = null

    fun setData(items: List<CapacityItem>) {
        this.items = items
    }

    fun setListener(listener: ProductCapacityVH.ProductCapacityListener?){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCapacityVH {
        return ProductCapacityVH.create(parent)
    }

    override fun onBindViewHolder(holder: ProductCapacityVH, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ProductCapacityVH(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: CapacityItem, listener: ProductCapacityListener?) {
        val card = view.findViewById<MaterialCardView>(R.id.item_capacity)
        val text = view.findViewById<TextView>(R.id.capacity_text)
        if (item.isActive) {
            card.setCardBackgroundColor(view.context.getColor(R.color.baseOrange))
            text.setTextColor(view.context.getColor(R.color.white))
            text.text = String.format("${item.capacity} gb").toUpperCase()
        } else {
            card.setCardBackgroundColor(view.context.getColor(R.color.white))
            text.setTextColor(view.context.getColor(R.color.textGray))
            text.text = String.format("${item.capacity}gb")
        }

        card.setOnClickListener {
            listener?.onCapacityClick(item.capacity)
        }

    }

    interface ProductCapacityListener{
        fun onCapacityClick(capacity: String)
    }

    companion object {
        fun create(parentView: ViewGroup): ProductCapacityVH {
            return ProductCapacityVH(
                LayoutInflater.from(parentView.context)
                    .inflate(R.layout.item_capacity, parentView, false)
            )
        }
    }
}