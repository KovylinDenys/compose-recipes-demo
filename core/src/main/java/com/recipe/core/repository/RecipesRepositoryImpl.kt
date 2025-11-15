package com.recipe.core.repository

import com.recipe.core.common.DataResult
import com.recipe.core.common.safeCall
import com.recipe.core.database.dao.RecipeDao
import com.recipe.core.mapper.toDomain
import com.recipe.core.mapper.toEntity
import com.recipe.core.model.Recipe
import com.recipe.core.network.api.RecipesApi

class RecipesRepositoryImpl(
    private val api: RecipesApi,
    private val recipeDao: RecipeDao
) : RecipesRepository {
    override suspend fun getRecipes(forceRefresh: Boolean): DataResult<List<Recipe>> {
        return safeCall {

            if (forceRefresh) {
                val remote = api.getRecipes()
                val entities = remote.map { it.toEntity() }
                recipeDao.replaceAll(entities)
            }

            recipeDao.getAll().map { it.toDomain() }
        }
    }
}