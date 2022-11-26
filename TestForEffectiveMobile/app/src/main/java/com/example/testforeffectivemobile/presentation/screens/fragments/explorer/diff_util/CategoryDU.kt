package com.example.testforeffectivemobile.presentation.screens.fragments.explorer.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.example.testforeffectivemobile.data.model.Category

class CategoryDU : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(p0: Category, p1: Category): Boolean {
        return p0.id == p1.id
    }

    override fun areContentsTheSame(p0: Category, p1: Category): Boolean {
        return p0 == p1
    }
}