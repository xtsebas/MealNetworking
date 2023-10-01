package com.example.networking.UIview.Mealdetail.repository

import com.example.networking.networking.MealsWebService
import com.example.networking.networking.response.DetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealDetailRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getMealDetail(mealId: String): DetailResponse? {
        println("Attempting to fetch meal detail with mealId: $mealId")
        println("URL: https://www.themealdb.com/api/json/v1/1/lookup.php?i=$mealId")

        return withContext(Dispatchers.IO) {
            try {
                val response = webService.getMealDetail(mealId)
                println("Response: $response")
                response
            } catch (e: Exception) {
                println("Error: ${e.localizedMessage}")
                null
            }
        }
    }
}