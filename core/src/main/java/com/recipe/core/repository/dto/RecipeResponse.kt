package com.recipe.core.repository.dto

data class RecipeResponse(
    val id: Int,
    val title: String,
    val ingredients: List<String>,
    val instructions: String,
    val imageUrl: String
)