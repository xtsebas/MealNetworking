package com.example.networking.UIview.Meals.View

import androidx.lifecycle.ViewModel
import com.example.networking.UIview.Meals.repository.MealsRepository
import com.example.networking.networking.response.MealResponse

class MealViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMeals(successCallback: (response: MealResponse?) -> Unit) {
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}