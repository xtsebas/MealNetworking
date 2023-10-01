package com.example.networking.networking.response

import com.google.gson.annotations.SerializedName

data class DetailResponse(@SerializedName("meals") val details: List<DetailItem>?)

data class DetailItem(
    @SerializedName("idMeal") val idMeal: String,
    @SerializedName("strMeal") val strMeal: String,
    @SerializedName("strInstructions") val strInstructions: String
)