package com.example.testforeffectivemobile.presentation.screens.fragments.explorer.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.example.testforeffectivemobile.data.model.BestSeller

class BestSellerDU : DiffUtil.ItemCallback<BestSeller>() {
    override fun areItemsTheSame(p0: BestSeller, p1: BestSeller): Boolean {
        return p0.id == p1.id
    }

    override fun areContentsTheSame(p0: BestSeller, p1: BestSeller): Boolean {
        return p0 == p1
    }
}