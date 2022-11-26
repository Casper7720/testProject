package com.example.testforeffectivemobile.presentation.screens.fragments.cart

import com.example.testforeffectivemobile.data.model.CartData
import com.example.testforeffectivemobile.data.networkpackage.use_case.CartUseCase
import com.example.testforeffectivemobile.presentation.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartUseCase: @JvmSuppressWildcards CartUseCase
) : BaseViewModel() {

    private var _cartData = MutableUIStateFlow<CartData>()
    var cartData = _cartData.asStateFlow()

    fun getCartData() {
        cartUseCase.invoke().collectRequest(_cartData) { it }
    }
}
