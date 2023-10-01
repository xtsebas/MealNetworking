package com.example.networking.UIview.Mealdetail.View

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun Mealdetail(mealId: String, navController: NavController) {

    val viewModel: MealDetailViewModel = viewModel()

    LaunchedEffect(mealId) {
        viewModel.getMealDetail(mealId)
    }

    val mealDetail by viewModel.mealDetail.collectAsState(null)

    val currentMealId by rememberUpdatedState(mealId)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        IconButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .align(Alignment.Start)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (mealDetail != null) {
            Column {
                Text(
                    text = mealDetail?.details?.first()?.strMeal ?: "Cargando...",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = mealDetail?.details?.first()?.strInstructions ?: "No instructions available",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        } else {
            Text("Cargando detalles de la comida...", style = MaterialTheme.typography.displayLarge)
        }
    }
}