package com.example.networking.networking

import com.example.networking.networking.response.DetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

sealed interface DetailsApi{
    @GET("filter.php")
    fun getDetails(@Query("c") category: String): Call<DetailResponse>
}