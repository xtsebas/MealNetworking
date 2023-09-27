package com.example.networking.UIview.Categories.View

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


@Composable
fun Categories(categories: MutableState<List<CategoryItem>?>) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            categories.value?.forEach { category ->
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
            Text(text = "Nombre de categoria: ${category.strCategory}")
            Text(text = "Descripción: ${category.strCategoryDescription}")
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}