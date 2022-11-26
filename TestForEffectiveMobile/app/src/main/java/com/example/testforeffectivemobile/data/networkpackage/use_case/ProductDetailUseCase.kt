package com.example.testforeffectivemobile.data.networkpackage.use_case


import com.example.testforeffectivemobile.data.networkpackage.repository.network.NetworkRepository
import javax.inject.Inject

class ProductDetailUseCase @Inject constructor(
    var repository: NetworkRepository
) {
    operator fun invoke() = repository.getProductDetailData()
}