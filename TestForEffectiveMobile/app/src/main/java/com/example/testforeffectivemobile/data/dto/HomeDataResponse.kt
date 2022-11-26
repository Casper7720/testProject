package com.example.testforeffectivemobile.data.dto

import com.example.testforeffectivemobile.data.model.BestSeller
import com.example.testforeffectivemobile.data.model.HomeData
import com.example.testforeffectivemobile.data.model.HomeStore
import com.google.gson.annotations.SerializedName

class HomeDataResponse(
    @SerializedName("best_seller")
    val best_seller: List<BestSellerResponse>,

    @SerializedName("home_store")
    val home_store: List<HomeStoreResponse>
)

fun HomeDataResponse.toDomain() = HomeData(
    bestSeller = best_seller.map { it.toDomain() },
    homeStore = home_store.map { it.toDomain() }
)

class BestSellerResponse(
    @SerializedName("discount_price")
    val discount_price: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_favorites")
    val is_favorites: Boolean,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("price_without_discount")
    val price_without_discount: Int,
    @SerializedName("title")
    val title: String
)

fun BestSellerResponse.toDomain() = BestSeller(
    discount_price,
    id,
    is_favorites,
    picture,
    price_without_discount,
    title
)

class HomeStoreResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_buy")
    val is_buy: Boolean,
    @SerializedName("is_new")
    val is_new: Boolean?,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String
)

fun HomeStoreResponse.toDomain() = HomeStore(
    id,
    is_buy,
    is_new,
    picture,
    subtitle,
    title
)