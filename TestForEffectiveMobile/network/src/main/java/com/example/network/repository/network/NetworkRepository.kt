package com.example.testforeffectivemobile.data.repository.network

import com.example.testforeffectivemobile.data.model.HomeData
import kotlinx.coroutines.flow.Flow
import arrow.core.Either
import com.example.testforeffectivemobile.data.model.CartData
import com.example.testforeffectivemobile.data.model.ProductDetailData

interface NetworkRepository {

    fun getHomeData(): Flow<Either<String, HomeData>>

    fun getProductDetailData(): Flow<Either<String, ProductDetailData>>

    fun getCartData(): Flow<Either<String, CartData>>
}