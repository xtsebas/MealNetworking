package com.example.networking.networking

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.networking.networking.response.CategoryItem
import com.example.networking.networking.response.CategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Composable
fun showCategories(): MutableState<List<CategoryItem>?> {
    val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(CategoriesApi::class.java)

    return getCategories(apiService)
}

@Composable
fun getCategories(apiService: CategoriesApi): MutableState<List<CategoryItem>?> {
    // Inicializa categories como null
    val categoriesState = remember { mutableStateOf<List<CategoryItem>?>(null) }

    val call = apiService.getCategories()

    call.enqueue(object : Callback<CategoryResponse> {
        override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
            if (response.isSuccessful) {
                // Asigna las categorías si la respuesta es exitosa
                response.body()?.categories?.let {
                    categoriesState.value = it
                }
            }
        }

        override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
            println("Error al obtener las categorías: ${t.message}")
        }
    })

    return categoriesState
}

