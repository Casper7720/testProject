package com.example.testforeffectivemobile.presentation.screens.fragments.product.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.testforeffectivemobile.R
import com.example.testforeffectivemobile.core.setImage
import com.example.testforeffectivemobile.presentation.screens.fragments.explorer.view_holder.BestSellerVH
import com.makeramen.roundedimageview.RoundedImageView


class ProductPreviewAdapter : RecyclerView.Adapter<ProductPreviewVH>() {

    private var items: List<String> = listOf()
    private var viewPager: ViewPager2? = null

    fun setData(items: List<String>) {
        this.items = items
    }

    fun setViewPager(viewPager: ViewPager2){
        this.viewPager = viewPager
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductPreviewVH {
        return ProductPreviewVH.create(parent)
    }

    override fun onBindViewHolder(holder: ProductPreviewVH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ProductPreviewVH(val view: View): RecyclerView.ViewHolder(view){

    fun bind(item: String){
        val image = view.findViewById<RoundedImageView>(R.id.product_preview_image)
        image.setImage(item)
    }

    companion object{
        fun create(parentView: ViewGroup): ProductPreviewVH {
            return ProductPreviewVH(
                LayoutInflater.from(parentView.context)
                    .inflate(R.layout.item_product_detail_preview, parentView, false)
            )
        }
    }
}