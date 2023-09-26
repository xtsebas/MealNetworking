package com.example.networking.networking.response

data class MealResponse(val meals: List<MealItem>)

class MealItem(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String,
    val strMealThumb: String,
    val strInstructions: String,
    val ingredients: List<Ingredient>
)

data class Ingredient(
    val ingredientName: String,
    val measure: String
)