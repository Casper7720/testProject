package com.example.testforeffectivemobile.presentation.screens.fragments.explorer.view_holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testforeffectivemobile.R
import com.example.testforeffectivemobile.data.model.Category
import com.google.android.material.card.MaterialCardView


class CategoryVH(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: Category, listener: CategoryListener?) {
        val image = view.findViewById<ImageView>(R.id.category_image)
        val title = view.findViewById<TextView>(R.id.category_text)
        val button = view.findViewById<MaterialCardView>(R.id.category_button_layout)

        title.text = item.title

        when (item.id){
            1->{
                image.setImageDrawable(view.context.getDrawable(R.drawable.ic_phone))
            }
            2->{
                image.setImageDrawable(view.context.getDrawable(R.drawable.ic_computer))
            }
            3->{
                image.setImageDrawable(view.context.getDrawable(R.drawable.ic_heart))
            }
            4->{
                image.setImageDrawable(view.context.getDrawable(R.drawable.ic_books))
            }
        }

        if(item.active){
            image.setColorFilter(view.context.getColor(R.color.white))
            title.setTextColor(view.context.getColor(R.color.baseOrange))
            button.setCardBackgroundColor(view.resources.getColor(R.color.baseOrange))
        }
        else{
            image.setColorFilter(view.context.getColor(R.color.normalGray))
            title.setTextColor(view.context.getColor(R.color.black))
            button.setCardBackgroundColor(view.resources.getColor(R.color.white))
        }

        button.setOnClickListener {
            listener?.click(item.id)
        }

    }

    interface CategoryListener{
        fun click(id: Int)
    }

    companion object {
        fun create(parentView: ViewGroup): CategoryVH {
            return CategoryVH(
                LayoutInflater.from(parentView.context)
                    .inflate(R.layout.item_category_button, parentView, false)
            )
        }
    }
}