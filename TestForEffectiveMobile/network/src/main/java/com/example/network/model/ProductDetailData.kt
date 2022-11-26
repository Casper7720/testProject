package com.example.testforeffectivemobile.data.model

data class ProductDetailData(
    val CPU: String,
    val camera: String,
    val capacity: List<CapacityItem>,
    val color: List<ColorItem>,
    val id: String,
    val images: List<String>,
    val isFavorites: Boolean,
    val price: Int,
    val rating: Double,
    val sd: String,
    val ssd: String,
    val title: String
)

data class ColorItem(
    var isActive: Boolean,
    val color: String
)

data class CapacityItem(
    var isActive: Boolean,
    val capacity: String
)