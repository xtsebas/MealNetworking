package com.example.networking.networking.response

import com.google.gson.annotations.SerializedName

data class MealResponse( val meals: List<MealItem>)

class MealItem(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)