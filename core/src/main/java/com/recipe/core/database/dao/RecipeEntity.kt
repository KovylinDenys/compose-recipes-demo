package com.recipe.core.database.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val ingredients: List<String>,
    val instructions: String,
    val imageUrl: String
)
