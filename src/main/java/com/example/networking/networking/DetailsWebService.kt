package com.example.networking.networking

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.networking.networking.response.CategoryItem
import com.example.networking.networking.response.CategoryResponse
import com.example.networking.networking.response.DetailItem
import com.example.networking.networking.response.DetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun showDetails(category: String): MutableState<List<DetailItem>?> {
    val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(DetailsApi::class.java)

    return getDetails(apiService, category)
}

@Composable
fun getDetails(apiService: DetailsApi, category: String): MutableState<List<DetailItem>?> {

    val detailsState = remember { mutableStateOf<List<DetailItem>?>(null) }

    val call = apiService.getDetails(category)

    call.enqueue(object : Callback<DetailResponse> {
        override fun onResponse(call: Call<DetailResponse>, response: Response<DetailResponse>) {
            if (response.isSuccessful) {
                response.body()?.details?.let {
                    detailsState.value = it
                }
            }
        }

        override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
            println("Error al obtener los detalles: ${t.message}")
        }
    })

    return detailsState
}