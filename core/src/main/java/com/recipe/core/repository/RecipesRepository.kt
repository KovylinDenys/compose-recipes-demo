package com.recipe.core.repository

import com.recipe.core.common.DataResult
import com.recipe.core.model.Recipe

interface RecipesRepository {
    suspend fun getRecipes(forceRefresh: Boolean): DataResult<List<Recipe>>
}