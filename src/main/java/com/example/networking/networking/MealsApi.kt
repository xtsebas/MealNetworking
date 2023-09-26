package com.example.networking.networking

import com.example.networking.networking.response.CategoryResponse
import com.example.networking.networking.response.DetailResponse
import com.example.networking.networking.response.MealResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

sealed interface MealsApi{
    @GET("lookup.php")
    fun getMealById(@Query("i") id: String): Call<MealResponse>
}
