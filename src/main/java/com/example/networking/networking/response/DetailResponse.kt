package com.example.networking.networking.response

data class DetailResponse(val details: List<DetailItem>)

data class DetailItem(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String,
    val strMealThumb: String,
)