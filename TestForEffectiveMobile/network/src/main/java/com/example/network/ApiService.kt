package com.example.network

import com.example.testforeffectivemobile.data.dto.CartResponse
import com.example.testforeffectivemobile.data.dto.HomeDataResponse
import com.example.testforeffectivemobile.data.dto.ProductDetailResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getHomeData(): HomeDataResponse

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getProductDetailData(): ProductDetailResponse

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCartData(): CartResponse

}