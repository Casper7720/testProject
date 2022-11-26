package com.example.network

object Common {
    private val BASE_URL = "https://run.mocky.io/v3/"
    val apiService: ApiService
        get() = RetrofitClient.getClient(BASE_URL).create(ApiService::class.java)
}