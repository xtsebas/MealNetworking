package com.example.networking.networking

import com.example.networking.networking.response.CategoryResponse
import retrofit2.Call
import retrofit2.http.GET

sealed interface CategoriesApi {
    @GET("categories.php")
    fun getCategories(): Call<CategoryResponse>
}