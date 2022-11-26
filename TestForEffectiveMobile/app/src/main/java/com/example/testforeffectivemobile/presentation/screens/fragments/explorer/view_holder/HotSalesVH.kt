package com.example.testforeffectivemobile.presentation.screens.fragments.explorer.view_holder

import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testforeffectivemobile.R
import com.example.testforeffectivemobile.core.setImage
import com.example.testforeffectivemobile.data.model.HomeStore
import com.example.testforeffectivemobile.data.model.HotSales
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView


class HotSalesVH(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: HomeStore) {
        val image = view.findViewById<ImageView>(R.id.product_image)
        val productTitle = view.findViewById<TextView>(R.id.title_product)
        val productDescription = view.findViewById<TextView>(R.id.description_product)
        val isNew = view.findViewById<MaterialCardView>(R.id.new_icon)
        val button = view.findViewById<MaterialButton>(R.id.buy_button)

        if(item.isNew == true){
            isNew.visibility = VISIBLE
        }
        else{
            isNew.visibility = INVISIBLE
        }

        productTitle.text = item.title
        productDescription.text = item.subtitle
        image.setImage(item.picture)

    }

    companion object {
        fun create(parentView: ViewGroup): HotSalesVH {
            return HotSalesVH(
                LayoutInflater.from(parentView.context)
                    .inflate(R.layout.item_hot_sales, parentView, false)
            )
        }
    }
}