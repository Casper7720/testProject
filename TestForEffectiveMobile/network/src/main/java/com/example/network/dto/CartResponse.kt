package com.example.testforeffectivemobile.data.dto

import com.example.testforeffectivemobile.data.model.Basket
import com.example.testforeffectivemobile.data.model.CartData
import com.google.gson.annotations.SerializedName

data class CartResponse(
    @SerializedName("basket")
    val basket: List<BasketResponse>,
    @SerializedName("delivery")
    val delivery: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("total")
    val total: Int
)

fun CartResponse.toDomain() = CartData(
    basket = basket.map { it.toDomain() },
    delivery,
    id,
    total
)

data class BasketResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("title")
    val title: String
)

fun BasketResponse.toDomain() = Basket(
    id,
    images,
    price,
    title
)