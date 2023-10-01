package com.example.networking.UIview.Mealdetail.View

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networking.UIview.Mealdetail.repository.MealDetailRepository
import com.example.networking.networking.response.DetailResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MealDetailViewModel( private val repository: MealDetailRepository = MealDetailRepository()) : ViewModel() {

    private val _mealDetail = MutableStateFlow<DetailResponse?>(null)
    val mealDetail: StateFlow<DetailResponse?> get() = _mealDetail

    fun getMealDetail(mealId: String) {
        viewModelScope.launch {
            val response = repository.getMealDetail(mealId)
            _mealDetail.value = response
        }
    }
}