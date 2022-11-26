package com.example.testforeffectivemobile.presentation.screens.fragments.cart.view_holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testforeffectivemobile.R
import com.example.testforeffectivemobile.core.setImage
import com.example.testforeffectivemobile.data.model.Basket
import com.example.testforeffectivemobile.data.model.BestSeller
import com.google.android.material.card.MaterialCardView
import com.makeramen.roundedimageview.RoundedImageView


class ProductCartVH(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: Basket, listener: ProductCartListener?) {
        val image = view.findViewById<RoundedImageView>(R.id.product_image)
        val productName = view.findViewById<TextView>(R.id.product_name)
        val totalPrice = view.findViewById<TextView>(R.id.product_total_price)
        val count = view.findViewById<TextView>(R.id.product_count)
        val plus = view.findViewById<MaterialCardView>(R.id.plus_layout)
        val minus = view.findViewById<MaterialCardView>(R.id.minus_layout)

        image.setImage(item.images)
        productName.text = item.title
        totalPrice.text = String.format("$${item.price}")

        if(item.count in 1..9){
            count.text = item.count.toString()
        }
        else{
            count.text = "X"
        }

        plus.setOnClickListener {
            listener?.plus(item.id)
        }

        minus.setOnClickListener {
            listener?.minus(item.id)
        }

    }

    interface ProductCartListener{
        fun plus(id: Int)
        fun minus(id: Int)
    }

    companion object {
        fun create(parentView: ViewGroup): ProductCartVH {
            return ProductCartVH(
                LayoutInflater.from(parentView.context)
                    .inflate(R.layout.item_cart, parentView, false)
            )
        }
    }
}