package com.recipe.core.model

data class RecipeDetails(
    val id: Int,
    val title: String,
    val ingredients: List<String>,
    val fullDescription: String,
    val instructions: String,
    val imageUrl: String
)