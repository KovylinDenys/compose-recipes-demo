package com.recipe.core.repository.dto

data class RecipeDetailsResponse(
    val id: Int,
    val title: String,
    val ingredients: List<String>,
    val fullDescription: String,
    val instructions: String,
    val imageUrl: String
)
