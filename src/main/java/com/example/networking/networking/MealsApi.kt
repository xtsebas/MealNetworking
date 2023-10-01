package com.example.networking.networking

import com.example.networking.networking.response.CategoryResponse
import com.example.networking.networking.response.DetailResponse
import com.example.networking.networking.response.MealResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi{
    @GET("categories.php")
    fun getMeals(): Call<MealResponse>

    @GET("filter.php")
    fun getMealsByCategory(@Query("c") category: String): Call<CategoryResponse>

    @GET("lookup.php")
    suspend fun getMealDetail(@Query("i") mealId: String): DetailResponse?
}