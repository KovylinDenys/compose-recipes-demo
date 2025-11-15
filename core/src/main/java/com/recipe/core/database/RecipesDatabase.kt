package com.recipe.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.recipe.core.database.dao.RecipeDao
import com.recipe.core.database.dao.RecipeEntity

@Database(
    entities = [RecipeEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RecipesDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}