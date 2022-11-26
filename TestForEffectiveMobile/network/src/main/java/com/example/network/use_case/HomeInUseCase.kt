package com.example.testforeffectivemobile.data.use_case

import com.example.testforeffectivemobile.data.repository.network.NetworkRepository
import javax.inject.Inject

class HomeInUseCase @Inject constructor(
    var repository: NetworkRepository
    ) {
    operator fun invoke() = repository.getHomeData()
}