package com.example.testforeffectivemobile.data.model



data class CartData(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)

data class Basket(
    val id: Int,
    val images: String,
    val price: Int,
    val title: String,
    var count: Int = 1
)
