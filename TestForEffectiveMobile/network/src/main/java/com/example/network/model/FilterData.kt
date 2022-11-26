package com.example.testforeffectivemobile.data.model

abstract class FilterData {
    abstract fun getTitle(): String
}

data class PriceFilter(var price: String) : FilterData() {
    override fun getTitle(): String = price
}

data class BrandFilter(var brand: String) : FilterData() {
    override fun getTitle(): String = brand
}

data class SizeFilter(var size: String) : FilterData() {
    override fun getTitle(): String = size
}