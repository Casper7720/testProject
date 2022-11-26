package com.example.testforeffectivemobile.data.networkpackage.repository.network

import arrow.core.Either
import com.example.testforeffectivemobile.data.dto.toDomain
import com.example.testforeffectivemobile.data.model.CartData
import com.example.testforeffectivemobile.data.model.HomeData
import com.example.testforeffectivemobile.data.model.ProductDetailData
import com.example.testforeffectivemobile.data.networkpackage.ApiService
import com.example.testforeffectivemobile.data.networkpackage.repository.BaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val service: ApiService
) : BaseRepository(), NetworkRepository {

    override fun getHomeData(): Flow<Either<String, HomeData>> = doRequest {
        service.getHomeData().toDomain()
    }

    override fun getProductDetailData(): Flow<Either<String, ProductDetailData>> = doRequest {
        service.getProductDetailData().toDomain()
    }

    override fun getCartData(): Flow<Either<String, CartData>> = doRequest {
        service.getCartData().toDomain()
    }

}