package com.example.networking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.networking.UIview.Categories.View.Categories
import com.example.networking.UIview.Mealdetail.View.MealDetail
import com.example.networking.networking.showCategories
import com.example.networking.networking.showDetails

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            //Categories(categories = showCategories())
            MealDetail(details = showDetails(category = "Seafood"))
        }
    }
}

