package com.example.networking.UIview.Categories.View

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.networking.Navigation.Screens
import com.example.networking.networking.response.CategoryItem


@Composable
fun MealsInCategoryScreen(categoryId: String, navController: NavController) {
    val viewModel: CategoriesViewModel = viewModel()
    val rememberedMeals: MutableState<List<CategoryItem>> = remember { mutableStateOf(emptyList<CategoryItem>()) }
    println("MealsInCategoryScreen Invoked with categoryId: $categoryId")

    viewModel.getMealsInCategory(categoryId) { response ->
        println("Response in Screen: $response")

        if (response != null) {
            val mealsFromTheApi = response?.categories
            rememberedMeals.value = mealsFromTheApi.orEmpty()
        }
    }

    LazyColumn {
        items(rememberedMeals.value) { meal ->
            ClickableText(
                text = AnnotatedString(text = meal.name),
                onClick = { offset ->
                    navController.navigate("${Screens.Detail.route}/${meal.idmeal}")
                }
            )
        }
    }
}