package com.example.networking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.networking.networking.CategoriesApi
import com.example.networking.networking.MealsApi
import com.example.networking.networking.response.CategoryItem
import com.example.networking.networking.response.CategoryResponse
import com.example.networking.ui.theme.NetworkingTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    private lateinit var apiService: CategoriesApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configurar Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Crear una instancia de la interfaz ApiService
        apiService = retrofit.create(CategoriesApi::class.java)

        // Llamar a la API
        getCategories()
    }

    private fun getCategories() {
        val call = apiService.getCategories()

        call.enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                if (response.isSuccessful) {
                    val categories = response.body()?.categories
                    if (categories != null) {
                        // Mostrar las categorías
                        setContent {
                            MyApp(categories)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                println("Error al obtener las categorías: ${t.message}")
            }
        })
    }
}

@Composable
fun MyApp(categories: List<CategoryItem>) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            categories.forEach { category ->
                CategoryCard(category)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun CategoryCard(category: CategoryItem) {
    Card {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "ID: ${category.idCategory}")
            Text(text = "Nombre: ${category.strCategory}")
            Text(text = "Descripción: ${category.strCategoryDescription}")
            Spacer(modifier = Modifier.height(8.dp))
            // Mostrar la imagen aquí si es necesario
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoryCard() {
    val sampleCategory = CategoryItem(
        idCategory = "1",
        strCategory = "Beef",
        strCategoryThumb = "https://www.themealdb.com/images/category/beef.png",
        strCategoryDescription = "Beef is the culinary name for meat from cattle..."
    )
    CategoryCard(sampleCategory)
}
