package com.example.testforeffectivemobile.presentation.dialogs.filter;

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SpinnerAdapter
import android.widget.TextView
import com.example.testforeffectivemobile.R
import com.example.testforeffectivemobile.data.model.FilterData


class FilterAdapter(var context: Context, var list: List<FilterData> = listOf()) : SpinnerAdapter {

    fun count(): Int {
        return list.size
    }

    override fun registerDataSetObserver(p0: DataSetObserver?) {}

    override fun unregisterDataSetObserver(p0: DataSetObserver?) {}

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(i: Int): FilterData {
        return list.get(i)
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View? {
        val rootView =
            LayoutInflater.from(context).inflate(R.layout.spinner_filter_preview, viewGroup, false)
        val title = rootView.findViewById<TextView>(R.id.spinner_preview_title)
        title.text = list[i].getTitle()
        return rootView
    }

    override fun getItemViewType(p0: Int): Int {
        return p0
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    override fun getDropDownView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val rootView =
            LayoutInflater.from(context).inflate(R.layout.spinner_filter_content, p2, false)
        val title = rootView.findViewById<TextView>(R.id.spinner_content_title)
        title.text = list[p0].getTitle()
        return rootView
    }
}