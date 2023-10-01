package com.example.networking.UIview.Categories.repository

import com.example.networking.networking.MealsWebService
import com.example.networking.networking.response.CategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMealsInCategory(categoryId: String, successCallback: (response: CategoryResponse?) -> Unit) {
        println("Repository getMealsInCategory Invoked with categoryId: $categoryId")

        return webService.getMealsInCategory(categoryId).enqueue(object :
            Callback<CategoryResponse> {
            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                println("API Call successful. Response: ${response.body()}, Error: ${response.errorBody()}")

                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                println("API Call failed. Error: $t")
            }
        })
    }
}