package com.example.testforeffectivemobile.presentation.screens.fragments.explorer.view_holder

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testforeffectivemobile.R
import com.example.testforeffectivemobile.core.setImage
import com.example.testforeffectivemobile.data.model.BestSeller
import com.google.android.material.card.MaterialCardView

class BestSellerVH(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: BestSeller, listener: BestSellerListener?) {
        val image = view.findViewById<ImageView>(R.id.product_image)
        val productName = view.findViewById<TextView>(R.id.product_name)
        val actualPrice = view.findViewById<TextView>(R.id.actual_product_price)
        val oldPrice = view.findViewById<TextView>(R.id.product_price)
        val isFavorite = view.findViewById<MaterialCardView>(R.id.favorite_button)
        val isFavoriteIcon = view.findViewById<ImageView>(R.id.favorite_icon)

        image.setImage(item.picture)
        productName.text = item.title
        actualPrice.text = String.format("$${item.discountPrice}")
        var textOldPrice = Html.fromHtml("<s>" + String.format("$${item.priceWithoutDiscount}") + "</s>")
        oldPrice.text =  textOldPrice

        if(item.isFavorites){
            isFavoriteIcon.setImageDrawable(view.context.getDrawable(R.drawable.ic_favorite_heart_full))
        }
        else{
            isFavoriteIcon.setImageDrawable(view.context.getDrawable(R.drawable.ic_favorite_heart))
        }


        image.setOnClickListener {
            listener?.onClick(item.id)
        }

        isFavorite.setOnClickListener {
            listener?.onFavoriteClick(item.id)
        }


    }

    interface BestSellerListener{
        fun onClick(id: Int)
        fun onFavoriteClick(id:Int)
    }

    companion object {
        fun create(parentView: ViewGroup): BestSellerVH {
            return BestSellerVH(
                LayoutInflater.from(parentView.context)
                    .inflate(R.layout.item_best_seller, parentView, false)
            )
        }
    }
}