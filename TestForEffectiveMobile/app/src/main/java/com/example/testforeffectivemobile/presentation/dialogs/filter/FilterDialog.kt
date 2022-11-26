package com.example.testforeffectivemobile.presentation.dialogs.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testforeffectivemobile.R
import com.example.testforeffectivemobile.data.model.BrandFilter
import com.example.testforeffectivemobile.data.model.PriceFilter
import com.example.testforeffectivemobile.data.model.SizeFilter
import com.example.testforeffectivemobile.databinding.DialogFilterBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FilterDialog : BottomSheetDialogFragment() {

    private lateinit var binding: DialogFilterBinding
    private lateinit var adapterBrand: FilterAdapter
    private lateinit var adapterPrice: FilterAdapter
    private lateinit var adapterSize: FilterAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = DialogFilterBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterBrand = FilterAdapter(
            view.context, listOf(
                BrandFilter("Samsung"),
                BrandFilter("Iphone"),
                BrandFilter("Xiaomi")
            )
        )
        adapterPrice = FilterAdapter(
            view.context, listOf(
                PriceFilter(
                    "$300 - $500"
                ),
                PriceFilter(
                    "$500 - $800"
                ),
                PriceFilter(
                    "$800 - $1000"
                )
            )
        )
        adapterSize = FilterAdapter(
            view.context, listOf(
                SizeFilter(
                    "4.5 to 5.5 inches"
                ),
                SizeFilter(
                    "5.5 to 6.5 inches"
                )
            )
        )
        binding.spinnerBrand.adapter = adapterBrand
        binding.spinnerPrice.adapter = adapterPrice
        binding.spinnerSize.adapter = adapterSize

        binding.closeButton.setOnClickListener {
            dialog?.dismiss()
        }
    }

    companion object {
        const val TAG = "filter_dialog"
    }
}