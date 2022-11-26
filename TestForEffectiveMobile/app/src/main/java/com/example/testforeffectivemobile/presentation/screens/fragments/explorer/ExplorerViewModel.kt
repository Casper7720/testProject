package com.example.testforeffectivemobile.presentation.screens.fragments.explorer

import com.example.testforeffectivemobile.data.model.Category
import com.example.testforeffectivemobile.data.model.HomeData
import com.example.testforeffectivemobile.data.networkpackage.use_case.HomeInUseCase
import com.example.testforeffectivemobile.presentation.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class ExplorerViewModel @Inject constructor(
    private val homeInUseCase: @JvmSuppressWildcards HomeInUseCase
) : BaseViewModel() {

    private val _homeData = MutableUIStateFlow<HomeData>()
    val homeData = _homeData.asStateFlow()


    private val categoriesList: List<Category> = listOf(
        Category(
            id = 0,
            title = "Phone",
            active = true
        ),
        Category(
            id = 1,
            title = "Computer",
            active = false
        ),
        Category(
            id = 2,
            title = "Heart",
            active = false
        ),
        Category(
            id = 3,
            title = "Books",
            active = false
        )
    )
    private val _categories: MutableStateFlow<List<Category>> = MutableStateFlow(categoriesList)
    val categories = _categories.asStateFlow()

    fun signIn() {
        homeInUseCase().collectRequest(_homeData) { it }
    }


}