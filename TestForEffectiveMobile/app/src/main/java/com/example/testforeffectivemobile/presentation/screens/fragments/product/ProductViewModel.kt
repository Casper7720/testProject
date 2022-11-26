package com.example.testforeffectivemobile.presentation.screens.fragments.product

import com.example.testforeffectivemobile.data.model.ProductDetailData
import com.example.testforeffectivemobile.data.networkpackage.use_case.ProductDetailUseCase
import com.example.testforeffectivemobile.presentation.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class ProductViewModel  @Inject constructor(
    private val productDetailUseCase: @JvmSuppressWildcards ProductDetailUseCase
) : BaseViewModel() {

    private val _productDetail = MutableUIStateFlow<ProductDetailData>()
    val productDetail = _productDetail.asStateFlow()

    fun signIn() {
        productDetailUseCase().collectRequest(_productDetail) { it }
    }
}