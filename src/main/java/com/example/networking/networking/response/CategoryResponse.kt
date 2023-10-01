package com.example.networking.networking.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse(@SerializedName("meals") val categories: List<CategoryItem>)

data class CategoryItem(
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val mealthumb: String,
    @SerializedName("idMeal") val idmeal: String
)
