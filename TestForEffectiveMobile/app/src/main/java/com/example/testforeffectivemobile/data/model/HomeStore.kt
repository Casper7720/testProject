package com.example.testforeffectivemobile.data.model

data class HomeStore(
    val id: Int,
    val isBuy: Boolean,
    val isNew: Boolean?,
    val picture: String,
    val subtitle: String,
    val title: String
)