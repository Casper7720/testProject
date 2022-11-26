package com.example.testforeffectivemobile.presentation.screens.fragments.product.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.testforeffectivemobile.R
import com.example.testforeffectivemobile.data.model.ColorItem
import com.google.android.material.card.MaterialCardView

class ProductColorAdapter : RecyclerView.Adapter<ProductColorVH>() {

    private var items: List<ColorItem> = listOf()
    private var listener: ProductColorVH.ProductColorListener? = null

    fun setData(items: List<ColorItem>) {
        this.items = items
    }

    fun setListener(listener: ProductColorVH.ProductColorListener?){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductColorVH {
        return ProductColorVH.create(parent)
    }

    override fun onBindViewHolder(holder: ProductColorVH, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ProductColorVH(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: ColorItem, listener: ProductColorListener?) {
        val card = view.findViewById<MaterialCardView>(R.id.item_color)
        val confirm = view.findViewById<ImageView>(R.id.confirm_img)
        card.setCardBackgroundColor(Color.parseColor(item.color))
        if (item.isActive) {
            confirm.visibility = VISIBLE
        } else {
            confirm.visibility = INVISIBLE
        }

        card.setOnClickListener {
            listener?.onColorClick(item.color)
        }
    }

    interface ProductColorListener{
        fun onColorClick(color: String)
    }

    companion object {
        fun create(parentView: ViewGroup): ProductColorVH {
            return ProductColorVH(
                LayoutInflater.from(parentView.context)
                    .inflate(R.layout.item_color, parentView, false)
            )
        }
    }
}