package com.example.testforeffectivemobile.presentation.screens.fragments.explorer.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.example.testforeffectivemobile.data.model.HomeStore
import com.example.testforeffectivemobile.data.model.HotSales


class HotSalesDU : DiffUtil.ItemCallback<HomeStore>() {
    override fun areItemsTheSame(p0: HomeStore, p1: HomeStore): Boolean {
        return p0.id == p1.id
    }

    override fun areContentsTheSame(p0: HomeStore, p1: HomeStore): Boolean {
        return p0 == p1
    }
}