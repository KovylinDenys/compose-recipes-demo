package com.recipe.core.model

data class Recipe(
    val id: Int,
    val title: String,
    val ingredients: List<String>,
    val instructions: String,
    val imageUrl: String
)