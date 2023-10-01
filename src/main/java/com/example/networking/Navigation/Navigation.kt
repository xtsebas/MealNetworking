package com.example.networking.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.networking.UIview.Categories.View.MealsInCategoryScreen
import com.example.networking.UIview.Mealdetail.View.Mealdetail
import com.example.networking.UIview.Meals.View.MealsCategoriesScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screens.Home.route,
        modifier = modifier) {
        composable(route = Screens.Home.route) {
            MealsCategoriesScreen(navController)
        }
        composable(route = Screens.Category.route) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            if (categoryId != null) {
                MealsInCategoryScreen(categoryId, navController)
            }
        }
        composable(route = "${Screens.Detail.route}/{mealId}") { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId")
            if (mealId != null) {
                Mealdetail(mealId)
            }
        }
    }
}