package com.example.networking.UIview.Categories.View

import androidx.lifecycle.ViewModel
import com.example.networking.UIview.Categories.repository.CategoriesRepository
import com.example.networking.networking.response.CategoryResponse

class CategoriesViewModel(private val repository: CategoriesRepository = CategoriesRepository()): ViewModel() {
    fun getMealsInCategory(categoryId: String, successCallback: (response: CategoryResponse?) -> Unit) {
        println("ViewModel getMealsInCategory Invoked with categoryId: $categoryId")

        repository.getMealsInCategory(categoryId) { response ->
            successCallback(response)
        }
    }
}