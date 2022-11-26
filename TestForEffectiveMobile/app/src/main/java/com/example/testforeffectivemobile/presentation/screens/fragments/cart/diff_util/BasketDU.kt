package com.example.testforeffectivemobile.presentation.screens.fragments.cart.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.example.testforeffectivemobile.data.model.Basket

class BasketDU : DiffUtil.ItemCallback<Basket>() {
    override fun areItemsTheSame(p0: Basket, p1: Basket): Boolean {
        return p0.id == p1.id
    }

    override fun areContentsTheSame(p0: Basket, p1: Basket): Boolean {
        return p0 == p1
    }
}