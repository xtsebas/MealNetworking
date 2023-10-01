package com.example.networking.UIview.Meals.View

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.networking.networking.response.MealItem
import com.example.networking.networking.response.MealResponse

@Composable
fun MealsCategoriesScreen(navController: NavController) {
    val viewModel: MealViewModel = viewModel()
    val rememberedMeals: MutableState<List<MealItem>> = remember { mutableStateOf(emptyList<MealItem>()) }

    viewModel.getMeals { response ->
        val mealsFromTheApi = response?.meals
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }

    LazyColumn {
        items(rememberedMeals.value) { meal ->
            ClickableText(
                text = AnnotatedString(text = meal.name),
                onClick = { offset ->
                    navController.navigate("Category/${meal.name}")
                }
            )
        }
    }

}