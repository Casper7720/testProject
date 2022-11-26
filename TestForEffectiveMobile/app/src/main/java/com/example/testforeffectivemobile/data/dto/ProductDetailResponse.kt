package com.example.testforeffectivemobile.data.dto

import com.example.testforeffectivemobile.data.model.CapacityItem
import com.example.testforeffectivemobile.data.model.ColorItem
import com.example.testforeffectivemobile.data.model.ProductDetailData
import com.google.gson.annotations.SerializedName

class ProductDetailResponse(
    @SerializedName("CPU")
    val CPU: String,
    @SerializedName("camera")
    val camera: String,
    @SerializedName("capacity")
    val capacity: List<String>,
    @SerializedName("color")
    val color: List<String>,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("isFavorites")
    val isFavorites: Boolean,
    @SerializedName("price")
    val price: Int,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("sd")
    val sd: String,
    @SerializedName("ssd")
    val ssd: String,
    @SerializedName("title")
    val title: String
)

fun ProductDetailResponse.toDomain() = ProductDetailData(
    CPU,
    camera,
    capacity = capacity.map { CapacityItem(false, it) },
    color = color.map { ColorItem(false, it) },
    id,
    images,
    isFavorites,
    price,
    rating,
    sd,
    ssd,
    title
)