package com.example.networking.networking.response

data class CategoryResponse(val categories: List<CategoryItem>)

data class CategoryItem(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)
