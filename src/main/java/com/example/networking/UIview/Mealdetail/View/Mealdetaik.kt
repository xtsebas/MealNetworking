package com.example.networking.UIview.Mealdetail.View

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.networking.networking.response.CategoryItem
import com.example.networking.networking.response.DetailItem

@Composable
fun MealDetail(details: MutableState<List<DetailItem>?>) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            details.value?.forEach { detail ->
                DetailCard(detail)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}


@Composable
fun DetailCard(detail: DetailItem) {
    Card {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "ID: ${detail.idMeal}")
            Text(text = "Nombre: ${detail.strCategory}")
            Text(text = "Descripción: ${detail.strMeal}")
            Text(text = "No se que es: ${detail.strMealThumb}")
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}