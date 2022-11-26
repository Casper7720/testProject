package com.example.testforeffectivemobile.data.model

data class BestSeller(
    val discountPrice: Int,
    val id: Int,
    var isFavorites: Boolean,
    val picture: String,
    val priceWithoutDiscount: Int,
    val title: String
)