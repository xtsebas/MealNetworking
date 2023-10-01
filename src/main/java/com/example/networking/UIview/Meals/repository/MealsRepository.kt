package com.example.networking.UIview.Meals.repository

import com.example.networking.networking.MealsWebService
import com.example.networking.networking.response.MealResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMeals(successCallback: (response: MealResponse?) -> Unit) {
        return webService.getMeals().enqueue(object : Callback<MealResponse> {
            override fun onResponse(
                call: Call<MealResponse>,
                response: Response<MealResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
                // TODO treat failure
            }
        })
    }
}